### General info
MaleOrang provides access to [MailChimp API v3.0](http://developer.mailchimp.com/documentation/mailchimp/reference/overview/) methods from Java code. It is a continuation of [ecwid-mailchimp](https://github.com/Ecwid/maleorang) which is no longer supported.

MaleOrang is written in [Kotlin language](https://kotlinlang.org/) and can be used with any language which runs on JVM. Refer to the [javadoc pages](http://www.javadoc.io/doc/com.raisin/maleorang/) for details.

### Supported MailChimp API methods

Currently MaleOrang has wrappers for a number of MailChimp API methods:
* [Members methods](http://developer.mailchimp.com/documentation/mailchimp/reference/lists/members/)
* [List methods](https://developer.mailchimp.com/documentation/mailchimp/reference/lists/)
* [Campaign methods](https://developer.mailchimp.com/documentation/mailchimp/reference/campaigns/)
* [Reports methods](https://developer.mailchimp.com/documentation/mailchimp/reference/reports/)
* [Batch Operations methods](http://developer.mailchimp.com/documentation/mailchimp/reference/batches/)

However, it is easy to extend the API and add support for any method you need (see the samples below).

### Code samples

* [Using an existing method implementation (Java)](https://github.com/raisin-gmbh/maleorang/blob/master/src/test/kotlin/com/ecwid/maleorang/examples/ExistingMethodExample.java)
* [Using an existing method implementation (Kotlin)](https://github.com/raisin-gmbh/maleorang/blob/master/src/test/kotlin/com/ecwid/maleorang/method/v3_0/lists/members/MembersTest.kt)
* [Using a custom method implementation (Java)](https://github.com/raisin-gmbh/maleorang/blob/master/src/test/kotlin/com/ecwid/maleorang/examples/CustomMethodExample.java)

### New features, changes, and bug fixes on version 3.0-0.9.7

Features
* [Reports method](https://developer.mailchimp.com/documentation/mailchimp/reference/reports/)
* [Reports SentTo method](https://developer.mailchimp.com/documentation/mailchimp/reference/reports/sent-to/)
* [DeleteMergeField method](https://developer.mailchimp.com/documentation/mailchimp/reference/lists/merge-fields/)

Changes
* Modified EditMemberMethod to allow emailAddress to be changed on a Member list.
* Added a Query String since parameter to GetEmailActivitysMethod.
* Enabled the overriding of the MailchimpClient method to facilitate mocking.
* Increased the connect and connectRequest timeOuts to 15 seconds, and the socketTimeOut to 5 minutes.
* Upgraded gradle wrapper to version 5.0 .
* Upgraded java version to 1.8 .
* Upgraded kotlin-stdlib and reflect libraries to 1.2.51 .

Bug fixes
* Corrected EditMergeFieldMethod response object to be MergeFieldInfo and not MemberInfo.

### New features, changes, and bug fixes on version 3.0-0.9.8

Changes
* Enhanced the MailchimpClient API to allow the optional parameterization of timeOut parameters (connectTimeOut, socketTimeOut, and connectionRequestTimeOut). 

### Build tools integration

MaleOrang is accessible from [Maven Central](https://mvnrepository.com/artifact/com.raisin/maleorang) so it can be easily integrated with your favorite build tools like Gradle or Maven.