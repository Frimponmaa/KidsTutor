package com.example.babylearn;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;
import android.app.Activity;
import android.widget.Toast;


@SuppressWarnings("deprecation")
public class GalleryActivity extends Activity implements ViewFactory{

	Integer[] images = {
			R.drawable.a1,R.drawable.beeee, R.drawable.c3, R.drawable.d4,
			R.drawable.e5,R.drawable.f6, R.drawable.g7, R.drawable.h7,
			R.drawable.i7,R.drawable.j7,R.drawable.k7,R.drawable.l7,
			R.drawable.m7,R.drawable.n7,R.drawable.o7,R.drawable.p7,
			R.drawable.q7,R.drawable.r7,R.drawable.s7,R.drawable.t7,
			R.drawable.u7,R.drawable.v7,R.drawable.w7,R.drawable.x7,
			R.drawable.y7,R.drawable.z7

	};
    Integer[] sounds = {
            R.raw.aaa1,R.raw.bbb1, R.raw.ccc1, R.raw.ddd1,R.raw.eee1,R.raw.fff1,R.raw.ggg1,R.raw.hhh1,R.raw.iii1,R.raw.jjj1,
            R.raw.kkk1,R.raw.lll1,R.raw.mmm1,R.raw.nnn1,R.raw.ooo1,R.raw.ppp1,R.raw.qqq1,R.raw.rrr1,R.raw.sss1,
            R.raw.ttt1,R.raw.uuu1,R.raw.vvv1,R.raw.www1,R.raw.xxx1,R.raw.yyy1,R.raw.zzz1
    };

	 private ImageSwitcher imageSwitcher;
	 
	 	public void onCreate(Bundle  savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gallery);
		
		Toast.makeText(getBaseContext(), "Select thumbnail to change image", Toast.LENGTH_SHORT).show();
		
		 	imageSwitcher = (ImageSwitcher) findViewById(R.id.switcher1);
		    imageSwitcher.setFactory(this);
		    imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left));
		    imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right));
		    
		    Gallery gallery = (Gallery) findViewById(R.id.gallery1);
		    gallery.setAdapter(new ImageAdapter(this));
		    gallery.setOnItemClickListener(new OnItemClickListener()
		    {
		    public void onItemClick(AdapterView<?> parent,
		    View v, int position, long id)
		    {
		    
		    	for(int i=0; i<images.length; i++){
		    		if(position == i){
		    		imageSwitcher.setImageResource(images[i]);
                        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), sounds[i]);
                        mp.start();
		    		}
		    	}
		   			
		 		    	}
		    });
		    }
		    public View makeView()
		    {
		    ImageView imageView = new ImageView(this);
		    imageView.setBackgroundColor(0xFFF);
		    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
		    imageView.setLayoutParams(new ImageSwitcher.LayoutParams(
		    LayoutParams.FILL_PARENT,
		    LayoutParams.FILL_PARENT));
		    return imageView;
		    }
		    public class ImageAdapter extends BaseAdapter
		    {
		    private Context context;
		    private int itemBackground;
		    public ImageAdapter(Context c)
		    {
		    context = c;
		    //---setting the style---
		    TypedArray a = obtainStyledAttributes(R.styleable.Gallery1);
		    itemBackground = a.getResourceId(R.styleable.Gallery1_android_galleryItemBackground, 0);
		    a.recycle();
		    }
		    //---returns the number of images---
		    public int getCount()
		    {
		    return images.length;
		    }
		    //---returns the item---
		    public Object getItem(int position)
		    {
		    return position;
		    }
		    //---returns the ID of an item---
		    public long getItemId(int position)
		    {
		    return position;
		    }
		    //---returns an ImageView view---
		    public View getView(int position, View convertView, ViewGroup parent)
		    {
		    ImageView imageView = new ImageView(context);
		    imageView.setImageResource(images[position]);
		    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
		    imageView.setLayoutParams(new Gallery.LayoutParams(250, 250));
		    imageView.setBackgroundResource(itemBackground);
		    return imageView;
		    
		    }
		    
	}
	
		   
}

