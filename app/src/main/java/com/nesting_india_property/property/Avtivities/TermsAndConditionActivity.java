package com.nesting_india_property.property.Avtivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.nesting_india_property.property.R;

public class TermsAndConditionActivity extends AppCompatActivity {


    String term = "<p style=\"margin-top:0;\">The website, www.NestingIndia.com (\"Site\") is an electronic web based platform acting in the capacity of a search engine or advertising agency only, for exchanging, exploring and enhancing business online for real estate, housing and property in India. It is owned and managed by Nesting India in Nagpur.<br><br>\n" +
            "\t\t\t\t\t\t\t\t\t   Any and all use of this website is subject to, and constitutes acknowledgment and acceptance of, the following Terms and Conditions (\"Terms\"). It is mandatory for all Users of the Site to have read carefully, fully understood and be in total agreement to the below mentioned Terms before they proceed to use any of the services of the Site (\"Services\"). The Services are available only to those individuals, firms or companies who can form legally binding contracts under the Indian laws. Nesting India may amend these Terms of Use at any time by posting the amended version on this site. Such amended version shall automatically be effective upon its posting on this site.\n" +
            "\t\t\t\t\t\t\t\t\t   </p>\n" +
            "\t\t<h3 class=\"heading\">DEFINITION CLAUSE:-</h3>\n" +
            "      <p style=\"margin-top:0;\">\n" +
            "\t  <strong>User:</strong> For purposes of this Agreement, a \"User\" is any person who accesses the Site for whatever purpose, regardless of whether said User has registered with www.NestingIndia.com as a registered User or whether said User is a paying User for a specific service provided by www.NestingIndia.com. A User includes the person using this Site and any legal entity which may be represented by such person under actual or apparent authority.\n" +
            "\t  </p>\n" +
            "      <p>\n" +
            "\t  <strong>Un-Authorized User:-</strong> Any person who does not have a legal or a contractual right to access the services, but does so, will fall within the definition of an 'unauthorized User' and will be subject to the terms and conditions, and expressly so with respect to respecting the intellectual property rights of the provider, and abiding by licensing terms and conditions.\n" +
            "\t  </p>\n" +
            "      <p>\n" +
            "\t  <strong>Free Services: </strong> Any person/entity that joins the portal www.NestingIndia.com just with the intention to enlist his listing and showcasing his business online without availing any specialized services thereto.\n" +
            "\t  </p>\n" +
            "      <p>\n" +
            "\t  <strong>Paid Services: </strong> Access to the Site and certain features are provided to all Users free of charge. However, the Site reserves the right, without prior notice, to restrict access to certain areas or features of the Site (\"Paid Services\") to paying Users or Users who undergo a specific registration process. Access to and use of these Paid Services is governed by additional terms and conditions under separate agreements in addition to this Agreement.\n" +
            "\t  </p>\n" +
            "\t  <p>\n" +
            "\t  The term RERDA shall mean and include the Real Estate (Regulation and Development) Act, 2016 as amended read with any rules or regulations that might be framed thereunder. By using the Site and its Services, the Users represent and warrant that (a) All registration information submitted is truthful and accurate; (b) The User will maintain the accuracy of such information; (c) The User is 18 years of age or older; and (d) The use of the Site does not violate any applicable law or regulation. (e) User's profile may be deleted and his Membership may be terminated without warning, if we believe that user is in breach of any of the above terms. (f) In no event the Site will be liable for any damages including, without limitation, indirect or consequential damages, or any damages whatsoever arising from use or loss of use, data, or profits, whether in action of contract, negligence or other tortuous action, arising out of or in connection with the use of the site.\n" +
            "\t  <br><br>\n" +
            "\t  That the Users agree to use this site only for lawful purposes, and in a manner which does not infringe the rights of, or restrict or inhibit the use and enjoyment of this site by any third party. Such restriction or inhibition includes, without limitation, conduct which is unlawful, or which may harass or cause distress or inconvenience to any person and the transmission of obscene or offensive content or disruption of normal flow of dialogue within this site. If any User/individual; /entity become aware of any inappropriate content by any User of this site, or otherwise please contact us by clicking on the \"Feedback\" link.\n" +
            "\t  The Site has no expertise in the domain of intellectual property rights of anyone. It is beyond our scope to verify that the User of the Site have posted ONLY products and services on which they have complete authorization / ownership / dealership / selling rights. As an INTERMEDIARY, our role is limited and in case you have any concern related to copyright infringement then we shall appreciate if the same is to be brought to our notice. The Site neither advocates / endorses such products that may be deemed to be infringing by the virtue of their being listed on the Site nor does it endorse the infringement by removing such listings.\n" +
            "\t  <br><br>\n" +
            "\t  That the Site shall not be liable for any such information or data which is not within its knowledge / acknowledgment / contraventions / copyright issues committed by its Users and which is beyond the control of verification.\n" +
            "\t  <br><br>\n" +
            "\t  That the Site shall have a sole discretion regarding deletion of his User's classifieds/listing/if the same is found to be in contravention of the various copyright right/intellectual property right rights of third party. That the present clause is in compliance with the INFORMATION TECHNOLOGY ACT 2000 and hence no discussion/argument shall be entertained in any case and in any circumstance.\n" +
            "\t  <br><br>\n" +
            "\t  This Agreement applies to each Paid Service (as defined below) in addition to any terms and conditions that may be applicable to such specific Paid Service provided, however, that in the event of any conflict or inconsistency between any provision of the terms and conditions that may be applicable to such Paid Service and any provision of this Agreement, such conflict or inconsistency shall (except as otherwise expressly provided or agreed) be resolved in a manner favorable to www.NestingIndia.com and/or its affiliates; and only to the extent that such conflict or inconsistency cannot be so resolved, the provisions of the terms and conditions applicable to such specific Paid Service shall prevail.\n" +
            "\t\t<br><br>\n" +
            "\t\twww.NestingIndia.com may amend this Agreement at any time by posting the amended and restated Agreement on the Site. The amended and restated Agreement shall be effective immediately upon posting. Posting by www.NestingIndia.com of the amended and restated Agreement and your continued use of the Site shall be deemed to be acceptance of the amended terms. This Agreement may not otherwise be modified, except in writing by an authorized officer of www.NestingIndia.com\n" +
            "\t\t<br><br>\n" +
            "\t\tMembership is activated within 2 working days from the receipt of activation charges and is continued for the period for which the activation charges have been submitted, however the Web pages are created as per the information/approval provided by the User and may take some time however no relaxation will be provided/allowed for the said period..\n" +
            "\t\t<br><br>\n" +
            "\t\tUsers be aware that the servers belongs to third party and the continuation to access the services are subject to availability as the same is interrupted at times by technical problems /hackers etc. and www.NestingIndia.com or the parent company is not responsible for the costs/damages/extension of activation period etc. for the same in any manner under any circumstances. The Users are advised to spool the messages etc. offline and save them elsewhere in order to avoid any hacking or technical problem.\n" +
            "\t\t<br><br>\n" +
            "\t\t<strong>Membership charges are subject to revision and are at the discretion of the www.NestingIndia.com</strong><br><br>\n" +
            "\t\tThe Nesting India reserves their right to block or delete the webpage at any time without assigning any reason etc. and the User's will have no claim or right whatsoever against www.NestingIndia.com under any circumstances.\n" +
            "\t\t<br><br>\n" +
            "\t\tUsers agree to accept communications (through Calls/Chat/ Mails/SMS/Whatsapp) on the numbers made available during registration or subsequently, via registration forms, posting requirements, feedbacks or any such form that has provision for phone number / mobile number irrespective of being on Do Not Call Registry; which include company / your number / an assigned point of contact; with respect to the subscribed services of www.NestingIndia.com .\n" +
            "\t\t\n" +
            "\n" +
            "\t  </p>\n" +
            "      <h3 class=\"heading\" >USER'S OBLIGATIONS</h3>\n" +
            "\t  <p>\n" +
            "\t  <ul style=\"margin-left:30px;\">\n" +
            "\t  <li>The User agrees and expressly states that he/she is solely responsible for the accuracy and completeness of the Registration Data and other information given to the Company in the application for Membership in order to use the Service. The User will ensure that the data shared with www.NestingIndia.com doesn't contain any fraudulent, false, misleading or manipulated facts.</li>\n" +
            "\t  <li>The User agrees to have / have acquired all the necessary rights and authorizations before posting any information on the Site including but not limited to listing information, property descriptions, photographs, maps, layouts, contact information etc.</li>\n" +
            "\t  <li>In case a User is covered under the RERDA, it shall ensure all necessary compliance necessary, including but not limited to obtaining the necessary registrations etc.</li>\n" +
            "\t  <li>The Site may also require the User to support his/her claims with respect to the status of the property with such documents as may be specified by it from time to time.</li>\n" +
            "\t  <li>The User is responsible for the set-up or configuration of all the necessary equipment required to access the Service.</li>\n" +
            "\t  <li>The User will comply with all notices or instructions given by the Company from time to time in respect of the use of the Service.</li>\n" +
            "\t  <li>The User shall be solely responsible for all information retrieved, stored and transmitted through the Service by him.</li>\n" +
            "\t  <li>The User is solely responsible for the maintenance of confidentiality of the login information.</li>\n" +
            "\t  <li>This would include the User's password and Username and all activities and transmission performed by the User at www.NestingIndia.com</li>\n" +
            "\t  <li>The User will immediately notify the Company of any unauthorized use of the User's account or any other breach of security known to the User.</li>\n" +
            "\t  <li>The User will pay promptly the Subscription Fees as required by the Company from time to time.</li>\n" +
            "\t  <li>The User will take all such measures as may be necessary (including without limitation changing his password from time to time) to protect the secrecy.</li>\n" +
            "\t  <li>In case you chose to discontinue your association with us, you can unsubscribe / remove your account by completing the delisting procedure using the Remove Account link available in your folder.</li>\n" +
            "\t \n" +
            "\t  \n" +
            "\t  </ul>\n" +
            "\t  </p>\n" +
            "\t  \n" +
            "\t  <h3 class=\"heading\" >PROPRIETARY RIGHTS IN CONTENT ON NESTINGINDIA.COM</h3>\n" +
            "\t  <p>\n" +
            "\t  www.NestingIndia.com owns and retains other proprietary rights in the site as well as the services. The Site contains the copyrighted material, trademarks, and other proprietary information of www.NestingIndia.com You may not copy, modify, publish, transmit, distribute, perform, display, or sell any such proprietary information, except for that information which is in the public domain or for which you have been given permission.\n" +
            "\t  </p>\n" +
            "\t  \n" +
            "\t   <h3 class=\"heading\" >INTELLECTUAL PROPERTY RIGHTS</h3>\n" +
            "\t  <p>\n" +
            "\t  All logos, brands, trademarks, registered marks (\"Marks\") appearing in www.NestingIndia.com are the properties either owned or used under license by the Company and / or its associates. All the rights accruing from the same, statutory or otherwise and intellectual property rights wholly vest with the Company / its associates. All rights not otherwise claimed under this Agreement or by the Company / its associates are hereby reserved.\n" +
            "\t  <br><br>\n" +
            "\t  The access to the Site does not confer upon the User any license or right to use these Marks and therefore the use of these Marks in any form or manner whatsoever is strictly prohibited. Any violation of the above would constitute an offence under the prevailing laws of India.\n" +
            "\t  </p>\n" +
            "\t  <h3 class=\"heading\" >PROHIBITED USE</h3>\n" +
            "\t  <p>\n" +
            "\t  <ul style=\"margin-left:30px;\">\n" +
            "\t  <li>•\tThe User shall not put to use the Services offered by the Site in any manner that impairs the interests and functioning of the Site and which is non-compliant with laws and regulations including RERDA.</li>\n" +
            "\t  <li>•\tThe User will not allow any person other than the authorized person(s) named in the application form to use the Service.</li>\n" +
            "\t  <li>•\tThe User shall use the Service only for the purpose for which it is subscribed.</li>\n" +
            "\t  <li>•\tThe User will comply with all applicable laws and shall not contravene any applicable law of India relating to the Services, including any regulation made pursuant thereto.</li>\n" +
            "\t  <li>•\tThe User shall not to use the Service for any unlawful purpose including without limitation criminal purposes.</li>\n" +
            "\t  <li>•\tThe User shall not to use the Service to send or receive any message, which is offensive on moral, religious, racial or political grounds or of an offensive, vulgar, obscene, malicious or menacing nature.</li>\n" +
            "\t  <li>•\tThe User shall be prohibited in persistently sending messages or make postings on www.NestingIndia.com to any other User or third party who access www.NestingIndia.com without reasonable cause or for causing any peril, harassment, annoyance, irritation, or anxiety to any person.</li>\n" +
            "\t  <li>•\tThe User is prohibited to introduce, upload, post, distribute, publish or transmit any information or software that:</li><br>\n" +
            "\t  <ul style=\"list-style:none;margin-left:25px;\">\n" +
            "\t  <li><strong>a.</strong>Contains a virus, worm or other harmful component into the Internet or www.NestingIndia.com network system.</li>\n" +
            "\t  <li><strong>b.</strong>Breaches on any intellectual property rights of any person or retain information in any computer system or otherwise with such intention.</li>\n" +
            "\t  <li><strong>c.</strong>Is unlawful, or which may potentially be perceived as being abusive, defamatory, libelous, harmful, threatening, harassing, vulgar, obscene, or racially, ethnically, or otherwise objectionable.</li>\n" +
            "\t  <li><strong>d.</strong>Is meant to mislead or deceive the other Users</li>\n" +
            "\t  <li><strong>e.</strong>Infringes any trademark, patent or copyright rights</li>\n" +
            "\t  \n" +
            "\t  </ul><br>\n" +
            "\t  In the event of a violation of any of the above mentioned covenants by the User, and same comes to the Company's knowledge, the Company shall have the right to delete any material relating to the violations without prior notice to the User. The Company shall issue a warning to the User to discontinue any activity, which leads to the said violations, and in the event the User continues with such activity, the Company has the sole authority to terminate or suspend the membership at www.NestingIndia.com and/or any other related facility. In addition to the right to indemnity available to the Company, the Company shall have the right to any legal remedy, against the User to recover the loss suffered by the Company and the harm caused to the goodwill of the Company, due to such violation by the User.\n" +
            "\t  <br><br>\n" +
            "\t  <h3>COPYRIGHT POLICY</h3>\n" +
            "\t  You may not post, distribute, or reproduce in any way any copyrighted material, trademarks, or other proprietary information without obtaining the prior written consent of the owner of such proprietary rights. Without limiting the foregoing,  \n" +
            "\t  <br><br>\n" +
            "\t  <h3>CONFIDENTIALITY</h3>\n" +
            "\t  As www.NestingIndia.com is an online platform so it cannot guarantee confidentiality of information provided by Users who use the Site, so any breach in privacy due to technical fault or any other means is not the responsibility of www.NestingIndia.com.\n" +
            "\t  <br><br>\n" +
            "\t  The User is entitled access to his own data and information stored in the database at www.NestingIndia.com (subject to prior confirmation of identity) and may edit or amend such data and information at any time.\n" +
            "\t  <br><br>\n" +
            "\t  The Users need to be aware that when they voluntarily reveal identification oriented information (name, e-mail address) to anyone resulting in unsolicited messages from third parties then such interaction is beyond the control and liability of www.NestingIndia.com.\n" +
            "\t<br><br>\n" +
            "\t  www.NestingIndia.com is liable to share all information available with it in response to any legal proceedings including and not restricted to court orders, notices, subpoena, FIR etc.\n" +
            "\t <br><br>\n" +
            "\t The copyright, know how or any other related intellectual property to the Service or www.NestingIndia.com shall be the sole and exclusive property of the Company. In the event the User has contributed any content to www.NestingIndia.com in any manner whatsoever, the intellectual property of the same shall stand automatically assigned to the Company and the User shall have no right or claim over the same. In the event the User during the term of his agreement or any time thereafter, uses such intellectual property in any other website or related activity, the same can be construed to be an infringement of the intellectual property belonging to the Company and the Company shall have the right to legal recourse in this regard.\n" +
            "\t <br><br>\n" +
            "\t The copyright, know how or any other related intellectual property to the Service or www.NestingIndia.com shall be the sole and exclusive property of the Company. In the event the User has contributed any content to www.NestingIndia.com in any manner whatsoever, the intellectual property of the same shall stand automatically assigned to the Company and the User shall have no right or claim over the same. In the event the User during the term of his agreement or any time thereafter, uses such intellectual property in any other website or related activity, the same can be construed to be an infringement of the intellectual property belonging to the Company and the Company shall have the right to legal recourse in this regard.\n" +
            "\t \n" +
            "\t  </p>";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_condition);


        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Terms And Conditions");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView text_term = findViewById(R.id.text_term);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            text_term.setText(Html.fromHtml(term, Html.FROM_HTML_MODE_COMPACT));
        } else {
            text_term.setText(Html.fromHtml(term));
        }

    }
}