package com.nesting_india_property.property.Avtivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import com.nesting_india_property.property.R;


public class AboutActivity extends AppCompatActivity {


    private ProgressDialog progressDialog;

    String yourData = "<h1 style=\"text-align: center\" class=\"section-title\">our story</h1> \n\n\n" +
            "                                <p class=\"px-3\">\n" +
            "\tThe days of relying on local dealers or \"mouth to mouth publicity\" to transact real estate transactions are long gone. The real estate industry has entered the E-World thanks to globalization and a fast-paced lifestyle. Active real estate participants are currently actively looking for the best opportunities to establish themselves in the E-Real Estate market. All of the issues that affect those who deal in real estate or who are looking for real estate can be resolved at www.NestingIndia.com. NestingIndia, one of the top real estate portals, keeps an eye on the real estate market. With its respected registered users and frequent visits from real estate industry participants, www.NestingIndia.com has developed into the real estate sector's hub. Know us\n" +
            "\t<br><br>\n" +
            "\tWe have been providing an internet platform that functions as a search engine and advertising agency for this market since. Thanks to our extensive experience in the same industry, we are now the only source of solutions. With our extensive experience in the aforementioned field, we are fully aware of the expectations of our customers and make every effort to satisfy them.\n" +
            "\t<br><br>\n" +
            "\tHaving made significant progress in the real estate industry, we have not wasted any time. We overcame all obstacles and persevered against all difficulties because we were determined to reach the top. The culmination of our clients' years-long trust has been this amazing accomplishment.\n" +
            "\t<br><br>\n" +
            "\tLeading brand in the industry, Nesting India, is the owner and manager of www.NestingIndia.Com.\n" +
            "\t\n" +
            "\t</p>\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "<h3 style=\"text-align: center\" >Fast Facts</h3>\n" +
            "\t<ul style=\"margin-left:30px;\">\n" +
            "\t<li><strong>Incepted in</strong> 2020</li>\n" +
            "\t<li><strong>Recognized as</strong> Single platform for versatile needs of Real estate World.</li>\n" +
            "\t<li><strong>Regularly visited by</strong> All the active partakers of Real estate industry.</li>\n" +
            "\t<li><strong>Crowded by</strong> Industrial leaders of real estate world.</li>\n" +
            "\t<li><strong>Visitors landing Page</strong> Increasing day by Day</li>\n" +
            "\t<li><strong>Services Offered :</strong> Provides Advertising platform to Agents, Buyers and Sellers.</li>\n" +
            "\t<li><strong>Property categories available</strong> Industrial, commercial, residential, agricultural and all other types of properties.</li>\n" +
            "\t<li><strong>Prime offer</strong> Free access to buyers/sellers database.</li>\n" +
            "\t<li><strong>Coverage </strong> Every nook n corner of India.</li>\n" +
            "\t<li><strong>Additionally</strong> Renders comprehensive information about property locations, prime attraction of areas, current trends and much more.</li>\n" +
            "\t<li><strong>Supported by</strong> An enthusiastic team of technical coordinators and customer care executives.</li>\n" +
            "\t<li><strong>Hot Deals</strong> A versatile range of pocket-friendly advertising solutions.</li>\n" +
            "\t<li><strong>Solutions available for</strong> Real Estate Agents, Builder & Developer, Property Owners, Property Buyers, Real Estate Sellers,  Consultant & Advisor, etc. and lots of more.</li>\n" +
            "\t\n" +
            "\t</ul>\n" +
            "\t<br>\n" +
            "\t<h3 style=\"text-align: center\">Our Forte</h3>\n" +
            "\t<p>\n" +
            "\tThanks to its distinctive characteristics, www.NestingIndia.com has become more reputable in the online business. In order to quench your hunger for information on real estate, housing, and property in India, Real Estate is a well-structured property portal. A crucial website that allows vendors, buyers, and brokers to quickly exchange information is www.NestingIndia.com. In addition, these are our main areas of expertise:\n" +
            "\t</p>\n" +
            "\t\n" +
            "\t<ul style=\"margin-left:30px;\">\n" +
            "\t<li>Comprehensive understanding of a chosen field. We have a great deal of experience and a thorough understanding of every facet of real estate, including its constantly shifting landscape. This helps us create solutions that meet the unique needs of our valued clients.</li>\n" +
            "\t<li>The key to our operation's effectiveness is our pool of professionals. Our highly skilled team deserves all the credit for providing services of the highest caliber; they put in endless effort to provide our valued clients with end-to-end solutions. Each member of our team is an expert in their own field. Aside from this, our team's unparalleled dedication makes every challenge a success. Our team of support professionals is constantly available to help you.</li>\n" +
            "\t<li>Navigate the enormous database pool. Our large database makes it simple for visitors to search properties across the country. This databank includes comprehensive information about real estate brokers, construction companies, contractors, etc., from across the nation.</li>\n" +
            "\t<li>This portal's user-friendly layout makes it simple to navigate. The Nesting India structure makes navigation simpler and quicker. Several features help visitors reach their desired page with the fewest clicks possible, such as the ability to search by property type, location, deals, etc.</li>\n" +
            "\t<li>Nesting India provides a broad range of reasonably priced solutions that are specifically designed to satisfy the various demands of the real estate industry. Our solutions are highly adaptable and suitable for a wide range of budgets.</li>\n" +
            "\t<ul>\n" +
            "\n" +
            "\n" +
            " <i class=\"material-icons mat-icon-xlg primary-color\">business</i>\n" +
            "                                            <h2 style=\"text-align: center\" class=\"capitalize fw-600 mx-2\">\n\nOur Mission</h2>\n" +
            "\n" +
            " <p class=\"mt-2\">\n" +
            "\tOur goal is to reach the point where we can successfully meet our clients' needs while maintaining the highest levels of cost- and transparency-effectiveness.\n" +
            "\t</p>\n" +
            "\n" +
            "   <i class=\"material-icons mat-icon-xlg primary-color\">list_alt</i>\n" +
            "                                            <h2 style=\"text-align: center\" class=\"capitalize fw-600 mx-2\">\n\nVision</h2>\n" +
            "\n" +
            "                                        <p class=\"mt-2\">To plant the seeds of excellence in services with a customer-centric mindset and gain the confidence of clients around the world.</p>\n" +
            "\n" +
            "\n" +
            "<h3 style=\"text-align: center\" >\n\nCore Values</h3>\n" +
            "<strong>\n\nTranspicuous Work Culture</strong><br>\n" +
            "There is always a connection between what we say and do. We firmly believe that transparency is right in terms of morality, law, and society.<br><br>\n" +
            "<strong>Result-Orientation</strong><br>\n" +
            "By establishing precise objectives, establishing priorities, allocating resources, and closely observing the project's development.<br><br>\n" +
            "<strong>Customer-Centric Approach</strong><br>\n" +
            "We value each client's individuality and work within their budget and requirements to create solutions that are similar to mirrors.<br><br>\n" +
            "\n" +
            "<h3 style=\"text-align: center\" >Innovation</h3>\n" +
            "Freeing the mind allows one to think and act unconventionally. We also look for the hidden opportunities that are present in client and colleague comments and suggestions.\n" +
            "Our commitment is to offer cost-effective advertising solutions and expand in tandem with our clients' needs. The desire to own a home actually begins in childhood, when we sketch and color our first impression of a home.  But as we get older, we understand that it takes more than just a game of paper and crayons—it takes a lot of work, money, proper guidance, knowledge, and other resources. Our goal is to become the most reliable resource for real estate investors and buyers, minimizing the difficulties that typically arise when looking for a property or making an offer.\n" +
            "\t<br><br><h3>\n" +
            "\tFinally, we would like to express our sincere gratitude to all of our visitors and registered members, as it has been their unwavering trust in us that has allowed us to become India's top property portal. They have served as the cornerstone of our achievements. It goes without saying that we will do everything in our power to help them whenever we can.\n" +
            "\t</h3>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);


        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("About Us..");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });
        progressDialog = new ProgressDialog(AboutActivity.this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.setCancelable(false);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView text_privacy = findViewById(R.id.text_privacy);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            text_privacy.setText(Html.fromHtml(yourData, Html.FROM_HTML_MODE_COMPACT));
        } else {
            text_privacy.setText(Html.fromHtml(yourData));
        }
}
}
