import greenfoot.*;
import java.util.List;

/**
 * An actor class that can display a scoreboard, using Greenfoot's
 * PlayerData class.  
 * 
 * You typically use this by including some code into the world for when your game ends:
 * 
 * <pre>
 *   addObject(new ScoreBoard(800, 600), getWidth() / 2, getHeight() / 2); 
 * </pre>
 * 
 * Where 800 by 600 should be replaced by the desired size of the score board. 
 * 
 * @author Neil Brown / Michael Kšlling
 * @version 1.2
 */
public class ScoreBoard extends Actor
{
    // The vertical gap between user images in the scoreboard:
    private static final int GAP = 10;
    
    // The height of the "All Players"/"Near Me" text at the top:
    private static final int HEADER_TEXT_HEIGHT = 25;
    
    // The main text color:
    private static final Color MAIN_COLOR = new Color(0x60, 0x60, 0x60); // dark grey
    
    // The score color:
    private static final Color SCORE_COLOR = new Color(0xB0, 0x40, 0x40); // orange-y

    /**
     * Constructor for objects of class ScoreBoard.
     * 
     * You can specify the width and height that the score board should be, but
     * a minimum width of 600 will be enforced.
     */
    public ScoreBoard(int width, int height)
    {    
        setImage(new GreenfootImage(Math.max(600, width), height));
        drawScores();
    }
    
    private void drawString(String text, int x, int y, Color color, int height)
    {
        getImage().drawImage(new GreenfootImage(text, height, color, null), x, y);
    }
    
    private void drawScores()
    { 
        // 50 pixels is the max height of the user image
        final int pixelsPerUser = 50 + 2*GAP;
        // Calculate how many users we have room for:
        final int numUsers = ((getImage().getHeight() - (HEADER_TEXT_HEIGHT + 10)) / pixelsPerUser);
        final int topSpace = getImage().getHeight() - (numUsers * pixelsPerUser) - GAP;

        drawString("Top Scores", 100, topSpace - HEADER_TEXT_HEIGHT - 5, MAIN_COLOR, HEADER_TEXT_HEIGHT);
        drawString("Near You", 100 + getImage().getWidth() / 2, topSpace - HEADER_TEXT_HEIGHT - 5, MAIN_COLOR, HEADER_TEXT_HEIGHT);        
        
        drawUserPanel(GAP, topSpace, (getImage().getWidth() / 2) - GAP, topSpace + numUsers * pixelsPerUser, UserInfo.getTop(numUsers));
        drawUserPanel(GAP + getImage().getWidth() / 2, topSpace, getImage().getWidth() - GAP, topSpace + numUsers * pixelsPerUser, UserInfo.getNearby(numUsers));
    }
    
    private void drawUserPanel(int left, int top, int right, int bottom, List users)
    {
        getImage().setColor(MAIN_COLOR);
        getImage().drawRect(left, top, right - left, bottom - top);
        
        int y = top + GAP;

        if (users == null) {
            getImage().setColor(Color.WHITE);
            getImage().fillRect(left + 5, y - GAP + 1, right - left - 10, 50 + 2*GAP - 1);
            int x = left + 10;
            drawString("You must be logged in to save your score", x, y+18, MAIN_COLOR, 14);
            return;
        }
        
        if (users.isEmpty()) {
            getImage().setColor(Color.WHITE);
            getImage().fillRect(left + 5, y - GAP + 1, right - left - 10, 50 + 2*GAP - 1);
            int x = left + 10;
            drawString("Please log in to save your score", x, y+18, MAIN_COLOR, 14);
            return;
        }
        
        for (Object obj : users)
        {
            UserInfo playerData = (UserInfo)obj;            
            Color c;
            if (playerData.getUserName().equals(UserInfo.getMyInfo().getUserName())) {
                // Highlight our row in a sky blue colour:
                c = new Color(180, 230, 255);
            }
            else {
                c = Color.WHITE;
            }
            getImage().setColor(c);
            getImage().fillRect(left + 5, y - GAP + 1, right - left - 10, 50 + 2*GAP - 1);

            int x = left + 10;
            drawString("#" + Integer.toString(playerData.getRank()), x, y+18, MAIN_COLOR, 14);
            x += 50;
            drawString(Integer.toString(playerData.getScore()), x, y+18, SCORE_COLOR, 14);
            x += 80;
            getImage().drawImage(playerData.getUserImage(), x, y);
            x += 55;
            drawString(playerData.getUserName(), x, y + 18, MAIN_COLOR, 14);
            y += 50 + 2*GAP;
        }
    }
}
