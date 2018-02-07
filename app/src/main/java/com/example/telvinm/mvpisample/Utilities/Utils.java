package com.example.telvinm.mvpisample.Utilities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.media.RingtoneManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils
{
    private static final String _CHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    public static int TYPE_WIFI = 1;
    public static int TYPE_MOBILE = 2;
    public static int TYPE_NOT_CONNECTED = 0;
    private static long mhr, mMn, mSe;
    private static long timeInMillisecondsdata;
    File dir = new File(Environment.getExternalStorageDirectory() + "Dir_name_here");
    private AlertDialog dialog;

    public static int getConnectivityStatus(Context context)
    {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (null != activeNetwork)
        {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
                return TYPE_WIFI;

            if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
                return TYPE_MOBILE;
        }
        return TYPE_NOT_CONNECTED;
    }

    public static String getConnectivityStatusString(Context context)
    {
        int conn = getConnectivityStatus(context);
        String status = null;
        if (conn == TYPE_WIFI)
        {
            status = "Wifi enabled";
        } else if (conn == TYPE_MOBILE)
        {
            status = "Mobile data enabled";
        } else if (conn == TYPE_NOT_CONNECTED)
        {
            status = "Not connected to Internet";
        }
        return status;
    }

    /**
     * Check network connection
     *
     * @param context
     * @return
     */
    public static boolean isNetWorkAvailable(Context context)
    {
        int status = getConnectivityStatus(context);
        if (status != 0)
        {
            return true;
        } else
        {
            return false;
        }
    }

    /**
     * remove last char of string
     *
     * @param str
     * @return
     */
    public static String removeLastChar(String str)
    {
        if (str != null && str.length() > 0 && str.charAt(str.length() - 1) == ',')
        {
            str = str.substring(0, str.length() - 1);
        }
        if (!TextUtils.isEmpty(str))
            return str;
        else
            return "";
    }

    /**
     * Validate email
     *
     * @param email
     * @return
     */
    public static boolean emailValidator(String email)
    {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * Password validation
     *
     * @param password
     * @return
     */
    public static boolean passwordValidation(String password)
    {
        if (password.length() < 6)
        {
            return false;
        } else if (isSpecialCharacterPresent(password))
        {
            return false;
        } else if (getNumberOfDigits(password) < 2)
        {
            return false;
        } else if (getNumberOfAlphabets(password) < 2)
        {
            return false;
        }
        return true;
    }

    /**
     * Get the number of alphabets in a string
     *
     * @param string
     * @return
     */
    private static int getNumberOfAlphabets(String string)
    {
        int count = 0;
        for (int i = 0, len = string.length(); i < len; i++)
        {
            if ((string.charAt(i) >= 'a' && string.charAt(i) <= 'z') || (string.charAt(i) >= 'A' && string.charAt(i) <= 'Z'))
            {
                count++;
            }
        }
        Log.e("Chara count", "" + count);
        return count;
    }

    /**
     * Get the number of digits in a string
     *
     * @param string
     * @return
     */
    private static int getNumberOfDigits(String string)
    {
        int count = 0;
        for (int i = 0, len = string.length(); i < len; i++)
        {
            if (Character.isDigit(string.charAt(i)))
            {
                count++;
            }
        }
        Log.e("Number count", "" + count);
        return count;
    }

    /**
     * Check wether the input contains special characters
     *
     * @param string
     * @return
     */
    private static boolean isSpecialCharacterPresent(String string)
    {
        if (string == null || string.trim().isEmpty())
        {
            return false;
        }
        int theCount = 0;
        for (int i = 0; i < string.length(); i++)
        {
            if (string.substring(i, i + 1).matches("[^A-Za-z0-9 ]"))
            {
                theCount++;
            }
        }
        if (theCount > 0)
            return true;
        else
            return false;
        /*Pattern p = Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(string);

        Log.e("Special", "" + m.find());
        return m.find();*/
    }

    public static String SHA1(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException
    {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(text.getBytes("iso-8859-1"), 0, text.length());
        byte[] sha1hash = md.digest();
        return convertToHex(sha1hash);
    }

    public static int getScreenOrientation(Activity activity)
    {
        Display getOrient = activity.getWindowManager().getDefaultDisplay();
        int orientation = Configuration.ORIENTATION_UNDEFINED;
        if (getOrient.getWidth() == getOrient.getHeight())
        {
            orientation = Configuration.ORIENTATION_SQUARE;
        } else
        {
            if (getOrient.getWidth() < getOrient.getHeight())
            {
                orientation = Configuration.ORIENTATION_PORTRAIT;
            } else
            {
                orientation = Configuration.ORIENTATION_LANDSCAPE;
            }
        }
        return orientation;
    }

    public static double getScreenInch(Context context)
    {
        try
        {
            // Compute screen size
            DisplayMetrics dm = context.getApplicationContext()
                    .getResources().getDisplayMetrics();
            float screenWidth = dm.widthPixels / dm.xdpi;
            float screenHeight = dm.heightPixels / dm.ydpi;
            double size = Math.sqrt(Math.pow(screenWidth, 2)
                    + Math.pow(screenHeight, 2));
            // Tablet devices should have a screen size greater than 6 inches
            return size;
        } catch (Throwable t)
        {
            return 0;
        }
    }

    public static String convertToHex(byte[] data)
    {
        StringBuilder buf = new StringBuilder();
        for (byte b : data)
        {
            int halfbyte = (b >>> 4) & 0x0F;
            int two_halfs = 0;
            do
            {
                buf.append(
                        (0 <= halfbyte) && (halfbyte <= 9) ? (char) ('0' + halfbyte) : (char) ('a' + (halfbyte - 10)));
                halfbyte = b & 0x0F;
            } while (two_halfs++ < 1);
        }
        return buf.toString();
    }

    /**
     * @return yyyy-MM-dd HH:mm:ss formate date as string
     */
    public static String getCurrentTimeStamp()
    {
        try
        {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
            String currentTimeStamp = dateFormat.format(new Date()); // Find todays date

            return currentTimeStamp;
        } catch (Exception e)
        {
            e.printStackTrace();

            return null;
        }
    }

    public static void showPdf(String path, Activity activity)
    {


        File file = new File(path);
        PackageManager packageManager = activity.getPackageManager();
        Intent testIntent = new Intent(Intent.ACTION_VIEW);
        testIntent.setType("application/pdf");
        List list = packageManager.queryIntentActivities(testIntent, PackageManager.MATCH_DEFAULT_ONLY);
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        Uri uri = Uri.fromFile(file);
        intent.setData(uri);
        intent.setDataAndType(uri, "application/pdf");
        PackageManager pm = activity.getPackageManager();
        List<ResolveInfo> activities = pm.queryIntentActivities(intent, 0);

        if (activities.size() > 0)
        {
            activity.startActivity(intent);
        }

    }

    public static String getDate(long milliSeconds, String dateFormat)
    {
        // Create a DateFormatter object for displaying date in specified format.
        DateFormat formatter = new SimpleDateFormat(dateFormat);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }

    public static long dateToMilliseconds(String date)
    {
        //String date_ = date;

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        // String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss");
        try
        {
            Calendar c = Calendar.getInstance();
            mhr = c.get(Calendar.HOUR_OF_DAY) * 60 * 60 * 1000;
            mMn = c.get(Calendar.MINUTE) * 60 * 1000;
            mSe = c.get(Calendar.SECOND) * 1000;
            timeInMillisecondsdata = mhr + mMn + mSe;
            Date mDate = sdf.parse(date);
            long time = mDate.getTime();
            long timeInMilliseconds = time + timeInMillisecondsdata;
            System.out.println("Date in milli :: " + timeInMilliseconds);
            System.out.println("Date in milli :: " + time);
            return timeInMilliseconds;
        } catch (ParseException e)
        {

            e.printStackTrace();
        }

        return 0;
    }

    public static void DownloadFile(String fileURL, File directory)
    {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try
        {


            URL u = new URL(fileURL);
            HttpURLConnection c = (HttpURLConnection) u.openConnection();
            //  c.setRequestMethod("GET");
            //  c.setDoOutput(true);
            c.connect();
            InputStream in = c.getInputStream();
            FileOutputStream f = new FileOutputStream(directory);
            int totalSize = c.getContentLength();
            byte[] buffer = new byte[1024 * 1024];
            int len1 = 0;
            while ((len1 = in.read(buffer)) > 0)
            {
                f.write(buffer, 0, len1);
            }
            f.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public static ArrayList<File> getFilesForUploading(File f, ArrayList<File> dir)
    {
        int fileCount = 0;

        if (f == null)
        {
            return dir;
        } else
            try
            {
                if (f.isDirectory())
                {
                    File[] listFile = f.listFiles();
                    if (listFile != null)
                    {
                        fileCount = listFile.length;
                        for (int i = 0; i < fileCount; i++)
                        {
                            if (listFile[i].isDirectory())
                            {
                                // dir = getFolderList(listFile[i], dir);
                                dir = getFilesForUploading(listFile[i],
                                        dir);

                            } else
                            {
                                String fName = listFile[i].getName();

                                if (fName.endsWith(".png")
                                        || fName.endsWith(".jpeg")
                                        || fName.endsWith(".jpg")
                                        || fName.endsWith(".PNG")
                                        || fName.endsWith(".JPG")
                                        || fName.endsWith(".JPEG")
                                        || fName.endsWith(".bmp"))
                                {

                                    dir.add(listFile[i]);

                                }
                            }
                        }
                    }

                }
            } catch (Exception e)
            {

                e.printStackTrace();
            }

        return dir;
    }

    public static void copyFile(String fromPath, String toPath)
    {
        try
        {
            File currentDB = new File(fromPath);
            File backupDB = new File(toPath);
            if (currentDB.exists() && backupDB.canWrite())
            {
                FileChannel src = new FileInputStream(currentDB).getChannel();
                FileChannel dst = new FileOutputStream(backupDB).getChannel();
                dst.transferFrom(src, 0, src.size());
                src.close();
                dst.close();
            }
        } catch (Exception e)
        {

            Log.e("copyFile exception", e.toString());

        }
    }

    public static void createFolder(File allDayCheckList)
    {

        if (!allDayCheckList.exists())
        {
            allDayCheckList.mkdirs();
        }

    }

    public static String getCurrentDateTime()
    {
        Calendar cal = Calendar.getInstance();
        Date dtime = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String curDate = sdf.format(dtime);
        return curDate;
    }

    public static void closeKeypad(Activity activity)
    {

        View view = activity.getCurrentFocus();
        if (view != null)
        {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static ArrayList<String> getListFiles(String mainFilePath)
    {
        ArrayList<String> inFiles = new ArrayList<String>();
        try
        {

            File directory = new File(mainFilePath);
            File[] files = directory.listFiles();
            if (files.length > 0)
            {
                for (File file : files)
                {
                    if (file.isDirectory())
                    {
                        inFiles.addAll(getListFiles(file.getAbsolutePath()));
                    } else
                    {
                        inFiles.add(file.getAbsolutePath());
                    }
                }
            }
            return inFiles;
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return inFiles;
    }

    public static int currentTimeMillis()
    {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public static void DeleteRecursive(File fileOrDirectory)
    {

        if (fileOrDirectory.isDirectory())
            for (File child : fileOrDirectory.listFiles())
                DeleteRecursive(child);
        if (!fileOrDirectory.getAbsolutePath().contains("report"))
        {
            fileOrDirectory.delete();
        }


    }

    public static void DeleteRecursiveGallery(File fileOrDirectory)
    {

        if (fileOrDirectory.isDirectory())
            for (File child : fileOrDirectory.listFiles())

                DeleteRecursive(child);
        if (!fileOrDirectory.getAbsolutePath().contains("report"))
        {
            File to = new File(fileOrDirectory.getAbsolutePath() + System.currentTimeMillis());
            fileOrDirectory.renameTo(to);
            fileOrDirectory.delete();
        }


    }


//    public static void DeleteDirectory(File fileOrDirectory) {
//
//        if (fileOrDirectory.isDirectory())
//            for (File child : fileOrDirectory.listFiles())
//                DeleteRecursive(child);
//
//    }

    public static void DeleteRecursivedir(File fileOrDirectory)
    {

        if (fileOrDirectory.isDirectory())
            for (File child : fileOrDirectory.listFiles())
                DeleteRecursive(child);
        // if (!fileOrDirectory.getAbsolutePath().contains("report")) {
        fileOrDirectory.delete();
        //}


    }

    public static void DeleteFilePath(File fileOrDirectory)
    {

        if (fileOrDirectory.isDirectory())
            for (File child : fileOrDirectory.listFiles())
                DeleteRecursive(child);
        fileOrDirectory.delete();
    }

    public static void DeleteFile(File fileOrDirectory)
    {

        if (fileOrDirectory.isDirectory())
        {
            String[] children = fileOrDirectory.list();
            for (int i = 0; i < children.length; i++)
            {
                new File(fileOrDirectory, children[i]).delete();
            }
        }
    }

    public static Bitmap decodeToBitStream(String filePath, int WIDTH, int HIGHT)
    {
        try
        {
            File f = new File(filePath);
            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(new FileInputStream(f), null, o);
            final int REQUIRED_WIDTH = WIDTH;
            final int REQUIRED_HIGHT = HIGHT;
            int scale = 1;
            while (o.outWidth / scale / 2 >= REQUIRED_WIDTH
                    && o.outHeight / scale / 2 >= REQUIRED_HIGHT)
                scale *= 2;
            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;
            return BitmapFactory.decodeStream(new FileInputStream(f), null, o2);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static void write(String fileName, String data)
    {
        Writer writer;
        File root = Environment.getExternalStorageDirectory();
        File outDir = new File(root.getAbsolutePath() + File.separator + "ALLDAY");
        if (!outDir.isDirectory())
        {
            outDir.mkdir();
        }
        try
        {
            if (!outDir.isDirectory())
            {
                throw new IOException(
                        "Unable to create directory EZ_time_tracker. Maybe the SD card is mounted?");
            }
            File outputFile = new File(outDir, fileName);
            writer = new BufferedWriter(new FileWriter(outputFile));
            writer.write(data);
            writer.close();
        } catch (IOException e)
        {

        }

    }

    public static String decimalFormat(String price)
    {
        try
        {
            if (TextUtils.isEmpty(price) || price.equalsIgnoreCase("null"))
                return "";
            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
            double decimalValue = Double.parseDouble(price);

            String result = decimalFormat.format(decimalValue);
            return new BigDecimal(result).stripTrailingZeros().toPlainString();
            //return result;
        } catch (Exception e)
        {
            return price;
        }
    }

    /*
     * getting screen width
     */
    public int getScreenWidth(Context context)
    {
        int columnWidth;
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();

        final Point point = new Point();
        try
        {
            display.getSize(point);
        } catch (NoSuchMethodError ignore)
        { // Older device
            point.x = display.getWidth();
            point.y = display.getHeight();
        }
        columnWidth = point.x;
        return columnWidth;
    }

    public static void showMessage(String string,Context context)
    {
        Toast.makeText(context,string, Toast.LENGTH_SHORT).show();
    }
}







