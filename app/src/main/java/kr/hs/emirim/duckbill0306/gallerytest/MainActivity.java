package kr.hs.emirim.duckbill0306.gallerytest;

import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {
    Gallery gallery;
    ImageView imgMain;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gallery = (Gallery) findViewById(R.id.gallery_1);
        imgMain = (ImageView) findViewById(R.id.imgv_main);
        MyGalleryAdapter adapter = new MyGalleryAdapter(this);
        gallery.setAdapter(adapter);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    public class MyGalleryAdapter extends BaseAdapter {
        Context context;
        int[] posterIDs = {R.drawable.ani_1, R.drawable.ani_2, R.drawable.ani_3, R.drawable.ani_4, R.drawable.ani_5,
                R.drawable.ani_6, R.drawable.ani_7, R.drawable.ani_8, R.drawable.ani_9, R.drawable.ani_10,};

        public MyGalleryAdapter(Context context) {
            this.context = context;
        }

        public int getCount() {
            return posterIDs.length;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imgV = new ImageView(context);
            imgV.setLayoutParams(new Gallery.LayoutParams(100, 150));
            imgV.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imgV.setPadding(5, 5, 5, 5);
            final int pos = position;
            imgV.setImageResource(posterIDs[position]);
            imgV.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    imgMain.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    imgMain.setImageResource(posterIDs[pos]);
                    return false;
                }
            });

            return imgV;
        }

        public long getItemId(int position) {
            return 0;
        }

        public Object getItem(int position) {
            return null;
        }
    }
}
