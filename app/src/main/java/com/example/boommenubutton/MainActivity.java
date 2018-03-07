package com.example.boommenubutton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.nightonke.boommenu.Animation.BoomEnum;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.TextOutsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
 BoomMenuButton bmb ;
 ArrayList<Integer> imageIDList;
 ArrayList<String> titleList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bmb = findViewById(R.id.boom);
        bmb.setPiecePlaceEnum(PiecePlaceEnum.DOT_9_1);
        bmb.setButtonPlaceEnum(ButtonPlaceEnum.SC_9_1);
        bmb.setButtonEnum(ButtonEnum.TextOutsideCircle);
        imageIDList =  new ArrayList<>();
        titleList =  new ArrayList<>();
        setInitialData();
        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++) {
            TextOutsideCircleButton.Builder builder = new TextOutsideCircleButton.Builder()
                    .normalImageRes(imageIDList.get(i))
                    .normalText(titleList.get(i))
                    .listener(new OnBMClickListener() {
                @Override
                public void onBoomButtonClick(int index) {
                    Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
                }
            });
            bmb.addBuilder(builder);
        }
    }

    private void setInitialData() {
        imageIDList.add(R.drawable.ic_cart);
        imageIDList.add(R.drawable.ic_collect);
        imageIDList.add(R.drawable.ic_eva);
        imageIDList.add(R.drawable.ic_list);
        imageIDList.add(R.drawable.ic_message);
        imageIDList.add(R.drawable.ic_random);
        imageIDList.add(R.drawable.ic_search);
        imageIDList.add(R.drawable.ic_service);
        imageIDList.add(R.drawable.ic_user);

        titleList.add("cart");
        titleList.add("collect");
        titleList.add("eva");
        titleList.add("list");
        titleList.add("message");
        titleList.add("random");
        titleList.add("search");
        titleList.add("service");
        titleList.add("user");
    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch(item.getItemId()) {
//            case R.id.menu_item1:
//                Intent intent = new Intent(this, ActivityForItemOne.class);
//                this.startActivity(intent);
//                break;
//            case R.id.menu_item2:
//                // another startActivity, this is for item with id "menu_item2"
//                break;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//        return true;
//    }
}
