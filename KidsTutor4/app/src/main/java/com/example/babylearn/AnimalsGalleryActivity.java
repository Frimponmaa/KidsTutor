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
public class AnimalsGalleryActivity extends Activity implements ViewFactory{

	Integer[] images = {
			R.drawable.alligator,R.drawable.bear,R.drawable.cat,R.drawable.donkey, R.drawable.elephant, R.drawable.flamingo,
            R.drawable.giraffe,R.drawable.hippopotamus,R.drawable.iguana,R.drawable.jaguar,R.drawable.kangeroon,R.drawable.lion,
            R.drawable.monkey,R.drawable.newt, R.drawable.ostrich,R.drawable.pig,R.drawable.quail,R.drawable.rhinoceros, R.drawable.sheep,
            R.drawable.tiger,
            R.drawable.unicornew,R.drawable.vulture,R.drawable.wolf,R.drawable.tetra,R.drawable.yak,R.drawable.zebra

	};Integer[] sounds = { R.raw.allig,R.raw.bea,R.raw.cat1,R.raw.donk,R.raw.eleph,R.raw.flami,R.raw.giraf,R.raw.hippopota,
                            R.raw.igua,R.raw.jagu,R.raw.kang,R.raw.lion1,R.raw.monk,R.raw.newt1,R.raw.ostri,R.raw.pig1,
                            R.raw.quail1,R.raw.rhino,R.raw.shee,R.raw.tige,R.raw.unic,R.raw.vult,R.raw.wolf1,R.raw.tetra2,R.raw.yak1, R.raw.zebr
    };
//r,u
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

