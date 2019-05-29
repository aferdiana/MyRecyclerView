package io.github.aferdiana.myrecyclerview;

import java.util.ArrayList;

public class DataDiscography {
    public static String[][] data = new String[][]{
            {"Queen", "Released: 13 July 1973\nLabel: EMI (#EMC 3006)", "https://upload.wikimedia.org/wikipedia/en/thumb/0/03/Queen_Queen.png/220px-Queen_Queen.png","UK: Gold\nUS: Gold"},
            {"Queen II", "Released: 8 March 1974\nLabel: EMI (#EMA 767)", "https://upload.wikimedia.org/wikipedia/en/thumb/4/43/Queen_II_%28album_cover%29.jpg/220px-Queen_II_%28album_cover%29.jpg","UK: Gold"},
            {"Sheer Heart Attack", "Released: 8 November 1974\nLabel: EMI (#EMC 3061)", "https://upload.wikimedia.org/wikipedia/en/thumb/f/f4/Queen_Sheer_Heart_Attack.png/220px-Queen_Sheer_Heart_Attack.png","UK: Platinum\nNL: Platinum\nUS: Gold\nRIAJ: Gold"},
            {"A Night at the Opera", "Released: 21 November 1975\nLabel: EMI (#EMTC 103)", "https://upload.wikimedia.org/wikipedia/en/thumb/4/4d/Queen_A_Night_At_The_Opera.png/220px-Queen_A_Night_At_The_Opera.png","UK: Platinum\nGER: Platinum\nAUT: Gold\nUS: 3x Platinum"},
            {"A Day at the Races", "Released: 10 December 1976\nLabel: EMI (#EMTC 104)", "https://upload.wikimedia.org/wikipedia/en/thumb/3/31/A_Day_at_the_Races_%28Queen%29.jpg/220px-A_Day_at_the_Races_%28Queen%29.jpg","UK: Gold\nNL: Gold\nUS: Platinum"},
            {"News of the World", "Released: 28 October 1977\nLabel: EMI (#EMA 784)", "https://upload.wikimedia.org/wikipedia/en/thumb/e/ea/Queen_News_Of_The_World.png/220px-Queen_News_Of_The_World.png","UK: Gold\nGER: Platinum\nNL: Platinum\nUS: 4x Platinum\nSNEP: Gold"},
            {"Jazz", "Released: 10 November 1978\nLabel: EMI (#EMA 788)", "https://upload.wikimedia.org/wikipedia/en/thumb/0/06/Queen_Jazz.png/220px-Queen_Jazz.png","UK: Gold\nGER: Gold\nAUT: Gold\nNL: Platinum\nUS: Platinum\nFRA: Gold"},
            {"The Game", "Released: 27 June 1980\nLabel: EMI (#EMA 795)", "https://upload.wikimedia.org/wikipedia/en/thumb/1/16/Queen_The_Game.png/220px-Queen_The_Game.png","UK: Gold\nGER: Gold\nAUT: Gold\nNL: Gold\nUS: 4x Platinum"},
            {"Flash Gordon", "Released: 8 December 1980\nLabel: EMI (#EMC 3351)", "https://upload.wikimedia.org/wikipedia/en/thumb/c/cc/Queen_Flash_Gordon.png/220px-Queen_Flash_Gordon.png","UK: Gold"},
            {"Hot Space", "Released: 21 May 1982\nLabel: EMI (#EMA 797)", "https://upload.wikimedia.org/wikipedia/en/thumb/3/3c/Queen_Hot_Space.png/220px-Queen_Hot_Space.png","UK: Gold\nAUT: Gold\nUS: Gold"},
            {"The Works", "Released: 27 February 1984\nLabel: EMI (#EMC 240014)", "https://upload.wikimedia.org/wikipedia/en/thumb/3/39/Queen_The_Works.png/220px-Queen_The_Works.png","UK: Platinum\nGER: Platinum\nAUT: Platinum\nNL: Gold\nUS: Gold"},
            {"A Kind of Magic", "Released: 3 June 1986\nLabel: EMI (#EU 3509)", "https://upload.wikimedia.org/wikipedia/en/thumb/6/63/Queen_A_Kind_Of_Magic.png/220px-Queen_A_Kind_Of_Magic.png","UK: 2× Platinum\nGER: 3× Gold\nAUT: Platinum\nUS: Gold\nFRA: Gold"},
            {"The Miracle", "Released: 22 May 1989\nLabel: Parlophone/EMI (#PCSD 107)", "https://upload.wikimedia.org/wikipedia/en/thumb/e/e3/Queen_The_Miracle.png/220px-Queen_The_Miracle.png","UK: Platinum\nGER: Platinum\nAUT: Gold\nNL: Platinum\nFRA: Gold"},
            {"Innuendo", "Released: 5 February 1991\nLabel: Parlophone/EMI, Hollywood (#PCSD 115)", "https://upload.wikimedia.org/wikipedia/en/thumb/f/f7/Queen_Innuendo.png/220px-Queen_Innuendo.png","UK: Platinum\nGER: Platinum\nAUT: Platinum\nNL: 2× Platinum\nUS: Gold\nFRA: Platinum"},
            {"Made in Heaven", "Released: 6 November 1995\nLabel: Parlophone/EMI, Hollywood (#PCSD 167)", "https://upload.wikimedia.org/wikipedia/en/thumb/0/03/Madeinheaven.jpg/220px-Madeinheaven.jpg","UK: 4× Platinum\nAUS: Platinum\nGER: 3× Platinum\nAUT: 2× Platinum\nNOR: Platinum\nUS: Gold\nFRA: 2× Platinum"}
    };

    public static ArrayList<QueenDiscography> getListData() {
        QueenDiscography queenDiscography = null;
        ArrayList<QueenDiscography> list = new ArrayList<>();
        for (String[] aData : data) {
            queenDiscography = new QueenDiscography();
            queenDiscography.setTitle(aData[0]);
            queenDiscography.setAlbumDetail(aData[1]);
            queenDiscography.setCover(aData[2]);
            queenDiscography.setCertification(aData[3]);

            list.add(queenDiscography);
        }
        return list;
    }
}
