### General info
MaleOrang provides access to [MailChimp API v3.0](http://developer.mailchimp.com/documentation/mailchimp/reference/overview/) methods from Java code. It is a replacement for [ecwid-mailchimp](https://github.com/Ecwid/ecwid-mailchimp/) which has now been deprecated.

MaleOrang is written in [Kotlin language](https://kotlinlang.org/) and can be used with any language which runs on JVM. Refer to the [javadoc pages](http://www.javadoc.io/doc/com.ecwid/maleorang/) for details.

### Supported MailChimp API methods

Currently MaleOrang has wrappers for a limited number of MailChimp API methods, namely:
* [Members methods](http://developer.mailchimp.com/documentation/mailchimp/reference/lists/members/)
* [Batch Operations methods](http://developer.mailchimp.com/documentation/mailchimp/reference/batches/)

However, it is easy to extend the API and add support for any method you need (see the samples below).

### Code samples

* [Using an existing method implementation (Java)](src/test/java/com/ecwid/maleorang/examples/ExistingMethodExample.java)
* [Using an existing method implementation (Kotlin)](src/test/java/com/ecwid/maleorang/method/v3_0/members/MembersTest.kt)
* [Using a custom method implementation (Java)](src/test/java/com/ecwid/maleorang/examples/CustomMethodExample.java)

### Build tools integration

MaleOrang is accessible from [Maven Central](http://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22com.ecwid%22%20AND%20a%3A%22maleorang%22) so it can be easily integrated with your favorite build tools like Gradle or Maven.
