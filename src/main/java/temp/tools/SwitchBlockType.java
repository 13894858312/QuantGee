package temp.tools;

import vo.BlockType;

/**
 * 将板块种类转为string blockname
 * Created by Mark.W on 2017/4/12.
 */
public class SwitchBlockType {

    public static String getBlockName(BlockType blockType) {
        String result = null;

        switch (blockType) {
            case MAIN_BLOCK:
                result = "000300";
                break;
            case MIDDLE_SMALL_BLOCK:
                result = "399005";
                break;
            case STARTUP_BLOCK:
                result = "399006";
                break;
        }

        return result;
    }
}
