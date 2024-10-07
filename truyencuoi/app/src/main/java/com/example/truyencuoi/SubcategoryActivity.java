package com.example.truyencuoi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class SubcategoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SubcategoryAdapter subcategoryAdapter;
    private List<Subcategory> subcategoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcategory);

        recyclerView = findViewById(R.id.recyclerViewSubcategory);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Nhận tiêu đề từ Intent
        String storyTitle = getIntent().getStringExtra("storyTitle");

        // Khởi tạo danh sách con dựa trên tiêu đề
        subcategoryList = new ArrayList<>();
        subcategoryList.add(new Subcategory("Lợn cưới áo mới", "Truyện kể về hai người đàn ông đều thích khoe của. Một người khoe con lợn mình mới mua để chuẩn bị cưới vợ, còn người kia khoe chiếc áo mới mặc. Cả hai gặp nhau và cuộc đối thoại của họ xoay quanh việc cố gắng khoe đồ đạc của mình khiến mọi người bật cười."));
        subcategoryList.add(new Subcategory("Đẽo cày giữa đường", "Truyện kể về một anh chàng cố gắng làm cái cày nhưng liên tục nghe theo lời khuyên của người đi đường. Cuối cùng, cái cày của anh trở nên không thể sử dụng được. Truyện cười về việc nghe lời người khác mà không suy nghĩ đến hoàn cảnh thực tế của mình.\n" +
                "\n"));
        subcategoryList.add(new Subcategory("Ba ông thầy bói xem voi", "Truyện kể về ba ông thầy bói mù cùng xem một con voi. Mỗi người sờ vào một phần của voi và kết luận rằng voi giống vật mà họ sờ thấy (vòi, tai, chân). Câu chuyện hài hước về sự nhận thức thiếu sót và sự mâu thuẫn trong đánh giá khi không có đủ thông tin."));

        subcategoryAdapter = new SubcategoryAdapter(subcategoryList, this);
        recyclerView.setAdapter(subcategoryAdapter);


    }
}
