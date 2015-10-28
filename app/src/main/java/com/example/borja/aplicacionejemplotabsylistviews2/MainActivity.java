package com.example.borja.aplicacionejemplotabsylistviews2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TabHost tabs;
    ArrayList<Contacto>arrContactos;
    Contacto[]datosContacto;
    ListView listaContactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabs=(TabHost)findViewById(android.R.id.tabhost);
        tabs.setup();
        TabHost.TabSpec spec=tabs.newTabSpec("LLAMADAS");
        spec.setContent(R.id.tabllamadas);
        spec.setIndicator("Llamadas");
        tabs.addTab(spec);

        spec=tabs.newTabSpec("CHATS");
        spec.setContent(R.id.tabchats);
        spec.setIndicator("Chats");
        tabs.addTab(spec);

        spec=tabs.newTabSpec("CONTACTOS");
        spec.setContent(R.id.tabcontactos);
        spec.setIndicator("contactos");
        tabs.addTab(spec);

        tabs.setCurrentTab(1);
        rellenaListaContactos(null);
    }
    public void rellenaListaContactos(Contacto c){
        arrContactos=new ArrayList<Contacto>();
        final Drawable imagen1= ContextCompat.getDrawable(getApplicationContext(), android.R.drawable.ic_menu_save);
        final Drawable imagen2= ContextCompat.getDrawable(getApplicationContext(), android.R.drawable.ic_menu_agenda);
        arrContactos.add(new Contacto("Contacto xx", "yy",  imagen1));
        arrContactos.add(new Contacto("Contacto xx", "yy",  imagen2));
        arrContactos.add(new Contacto("Contacto xx", "yy",  imagen1));
        arrContactos.add(new Contacto("Contacto xx", "yy",  imagen1));
        arrContactos.add(new Contacto("Contacto xx", "yy",  imagen2));
        arrContactos.add(new Contacto("Contacto xx", "yy",  imagen1));
        arrContactos.add(new Contacto("Contacto xx", "yy",  imagen2));
        /*Pasar drawable entre intents
        * Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
            byte[] b = baos.toByteArray();

            Intent intent = new Intent(this, ActivityB.class);
            intent.putExtra("picture", b);
            startActivity(intent);
        *In Activity B you receive intent with byte array (decoded picture) and apply it as source to ImageView:

            Bundle extras = getIntent().getExtras();
            byte[] b = extras.getByteArray("picture");

            Bitmap bmp = BitmapFactory.decodeByteArray(b, 0, b.length);
            ImageView image = (ImageView) findViewById(R.id.imageView1);

            image.setImageBitmap(bmp);
        * */
        if(c!=null)
            arrContactos.add(c);
        datosContacto=new Contacto[arrContactos.size()];
        for(int i=0;i<arrContactos.size();i++)
            datosContacto[i]=arrContactos.get(i);
        AdaptadorContactos adaptador=new AdaptadorContactos(this,datosContacto);
        listaContactos=(ListView)findViewById(R.id.ListViewContactos);
        listaContactos.setAdapter(adaptador);
        listaContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,ContactoDetalles.class);
                intent.putExtra("nombre",datosContacto[position].getNombreContacto());
                intent.putExtra("nick",datosContacto[position].getNick());
                Bitmap bitmap = ((BitmapDrawable)datosContacto[position].getImageIcon()).getBitmap();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
                byte[] b = baos.toByteArray();
                intent.putExtra("imagen",b);
                startActivity(intent);
            }
        });

    }
}
