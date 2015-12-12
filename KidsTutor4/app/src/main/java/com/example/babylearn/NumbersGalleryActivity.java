package com.example.babylearn;

/*Dear Eunice
 * I am going to comment this code as well as i can. If you find any difficulties in the java code, please contact Andy
 * But if you both still dont get something then you can contact me.
 * I might overlook certain things because perhaps I assumed you'd know.
 * So if the overlooking becomes too much please let me know
 * 
 * The Gallery Activities are all the same with slight changes so I'm commenting just this one.
 * If the code is well understood, you can make a lot of changes
 * This java class is where the logic resides, but any changes you want to make in the GUI is in the XML
 * It can be done here too but its a bit complicated
 * 
 * Thank you
 */
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
//This class extends Activity since android application consists of one or more Activities
//It also the implements the ViewFactory interface which is reponsible for handling the gallery and imageSwitcher
public class NumbersGalleryActivity extends Activity implements ViewFactory{

	//this array contains the images. Data type is in integer since the files are refernced in memory with integers
	Integer[] images = {
			R.drawable.zerozero,R.drawable.un,R.drawable.deux, R.drawable.trois, R.drawable.quatre,
			R.drawable.cinq,R.drawable.sixt, R.drawable.sept, R.drawable.huit, R.drawable.neuf
			
	};     
	//Same applies to the sound files in the raw folder belonging under res(resources) folder
	Integer[] sounds = {
			R.raw.zero0,R.raw.one1, R.raw.two2, R.raw.three3,R.raw.four4,R.raw.five5,R.raw.six6,R.raw.seven7,R.raw.eight8,R.raw.nine9
	};

	//declaration of the imageSwitcher
	 private ImageSwitcher imageSwitcher;
	 
	 //this part is like the public static void main we know in Java
	 	public void onCreate(Bundle  savedInstanceState){
		super.onCreate(savedInstanceState);
		//here you tell the java class to perform its functions on the gallery xml you designed
		setContentView(R.layout.gallery);
		
		//This is what pops up that brief message each time you enter the menu item
		Toast.makeText(getBaseContext(), "Select thumbnail to change image", Toast.LENGTH_SHORT).show();
		
		/*here the findviewbyid links the variable you have declared in the java activity to the id of the 
		 * component defined in the design layout. ie. the XML file, in this case gallery.xml
		 */
		 	imageSwitcher = (ImageSwitcher) findViewById(R.id.switcher1);
		    imageSwitcher.setFactory(this);
		    //this part is self explanatory. Basically deals with how the images transition
		    imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left));
		    imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right));
		    
		    
		    /*Now the gallery is that small widget up there that you select the thumbnail from
		     * Likewise we also link it to the xml using the findview by id
		     * now we use its method called setOnItemClickListener. Ideally it does nothing. But i have wirtten the code
		     * such that it uses the for loop to go through the images and sounds array and both display and play sound at current position 
		     */
		    Gallery gallery = (Gallery) findViewById(R.id.gallery1);
		    gallery.setAdapter(new ImageAdapter(this));
		    gallery.setOnItemClickListener(new OnItemClickListener()
		    {
		    public void onItemClick(AdapterView<?> parent,
		    View v, int position, long id)
		    {
		    
		    	//this part is the loop i was talking about
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
	 	
	 	//the make view method defines the look of the image that slides in or out upon selection
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
		    
		    //The image adapter is the class that is responsible for handling the images
		    //From the number of images, the size of the gallery widget, position etc.
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

