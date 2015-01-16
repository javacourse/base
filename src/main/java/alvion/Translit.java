package alvion;

/**
 * Created by Ilya Ten
 * Date: 1/14/2015
 * Class to transliterate Cyrillic to Latin
 */

public class Translit {

    static String[] unicode_cyr_lat_map = {
          //Ё
          //1025   1026   1027   1028   1029   1030   1031   1032   1033   1034   1035   1036   1037   1038   1039
            "JO",  "",    "",    "",    "",    "",    "",    "",    "",    "",    "",    "",    "",    "",    "",
          //А      Б      В      Г      Д      Е      Ж      З      И      Й      К      Л      М      Н      О
          //1040   1041   1042   1043   1044   1045   1046   1047   1048   1049   1050   1051   1052   1053   1054
            "A",   "B",   "V",   "G",   "D",   "E",   "GZ",  "Z",   "I",   "J",   "K",   "L",   "M",   "N",   "O",
          //П      Р      С      Т      У      Ф      Х      Ц      Ч      Ш      Щ      Ъ      Ы      Ь      Э
          //1055   1056   1057   1058   1059   1060   1061   1062   1063   1064   1065   1066   1067   1068   1069
            "P",   "R",   "S",   "T",   "U",   "F",   "H",   "Z",   "CH",  "SH",  "SCH", "'",   "I",   "J",   "JE",
          //Ю      Я      а      б      в      г      д      е      ж      з      и      й      к      л      м
          //1070   1071   1072   1073   1074   1075   1076   1077   1078   1079   1080   1081   1082   1083   1084
            "JU",  "JA",  "a",   "b",   "v",   "g",   "d",   "e",   "gz",  "z",   "i",   "j",   "k",   "l",   "m",
          //н      о      п      р      с      т      у      ф      х      ц      ч      ш      щ      ъ      ы
          //1085   1086   1087   1088   1089   1090   1091   1092   1093   1094   1095   1096   1097   1098   1099
            "n",   "o",   "p",   "r",   "s",   "t",   "u",   "f",   "h",   "z",   "ch",  "sh",  "sch", "'",   "i",
          //ь      э      ю      я             ё
          //1100   1101   1102   1103   1104   1105
            "j",   "je",  "ju",  "ja",  "",    "jo"
    };
    static int convert_min_code = 1025;



    public static String transliterateCyrToLat (char[] inputChars) {

        StringBuilder result = new StringBuilder();
        int convertLastCode = convert_min_code + unicode_cyr_lat_map.length - 1;
        for (int i = 0; i < inputChars.length; i++ ) {
            int charCode = Character.codePointAt(inputChars, i);
            if (convert_min_code <= charCode && charCode <= convertLastCode
                    && !(unicode_cyr_lat_map[charCode - convert_min_code]).isEmpty())
            {
                result.append(unicode_cyr_lat_map[charCode - convert_min_code]);
            }
            else {
                result.append(inputChars[i]);
            }
        }
        return result.toString();
    }
}
