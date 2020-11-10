<p align="center">
    <img title="Flutterwave" height="200" src="https://flutterwave.com/images/logo-colored.svg" width="50%"/>
</p>

# Flutterwave Android SDK

## Before you begin
- Ensure you have your test (and live) [API keys](https://developer.flutterwave.com/docs/api-keys).

## Requirements
- The minimum supported SDK version is 15
- Rave android sdk 1.0.50 and above only supports projects that have been migrated to [androidx](https://developer.android.com/jetpack/androidx/). For more information, read Google's [migration guide](https://developer.android.com/jetpack/androidx/migrate).

## Adding it to your project


**Step 1.** Add it in your root build.gradle at the end of repositories:
```groovy
    allprojects {
		repositories {
			//...
			maven { url 'https://jitpack.io' }
		}
	}
```
**Step 2.** Add the dependency

If you want to use the default Drop In UI, add the `rave-android` module dependency and fragment dependency. 
Check https://developer.android.com/training/basics/fragments/pass-data-between for more information and the latest version of the fragment library
```groovy
    dependencies {
	     implementation 'implementation 'com.github.mikelis135:rave-android:1.1.13'
	     implementation 'androidx.fragment:fragment:1.3.0-alpha04'
	}
```
**Step 3.** Add the  `INTERNET` permission to your android manifest

     <uses-permission android:name="android.permission.INTERNET" /> 


> The steps below show how to use the Flutterwave Android SDK as a Drop-in UI (all the views for the payment process are handled by the SDK).

## Usage
### For using the default UI
###  1. Create a `RaveUiManager` instance
Set the public key, encryption key and other required parameters. The `RaveUiManager` accepts a mandatory instance of the calling `Fragment` and an instance of the parent `Activity`.

        new RaveUiManager(fragment).setAmount(amount)
                        .setCurrency(currency)
                        .setEmail(email)
                        .setfName(fName)
                        .setlName(lName)
                        .setNarration(narration)
                        .setPublicKey(publicKey)
                        .setEncryptionKey(encryptionKey)
                        .setTxRef(txRef)
                        .setPhoneNumber(phoneNumber, boolean)
                        .acceptAccountPayments(boolean)
                        .acceptCardPayments(boolean)
                        .acceptMpesaPayments(boolean)
                        .acceptAchPayments(boolean)
                        .acceptGHMobileMoneyPayments(boolean)
                        .acceptUgMobileMoneyPayments(boolean)
                        .acceptZmMobileMoneyPayments(boolean)
                        .acceptRwfMobileMoneyPayments(boolean)
                        .acceptSaBankPayments(boolean)
                        .acceptUkPayments(boolean)
                        .acceptBankTransferPayments(boolean)
                        .acceptUssdPayments(boolean)
                        .acceptBarterPayments(boolean)
                        .acceptFrancMobileMoneyPayments(boolean)
                        .allowSaveCardFeature(boolean)
                        .onStagingEnv(boolean)
                        .setMeta(List<Meta>)
                        .withTheme(styleId)
                        .isPreAuth(boolean)
                        .setSubAccounts(List<SubAccount>)
                        .shouldDisplayFee(boolean)
                        .showStagingLabel(boolean)
			    .embedFragment(int, appcompatActivity)
                        .initialize();


###  2. Handle the response
In the calling Frgament, use the setFragmentResultListener method to receive the payment response as shown below
```java
	getParentFragmentManager().setFragmentResultListener(RAVE_REQUEST_KEY, this, new FragmentResultListener() {
	  
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
		
		int resultCode = result.getInt("resultCode");
                int requestCode = result.getInt("requestCode");
		
			/*
			 *  We advise you to do a further verification of transaction's details on your server to be
			 *  sure everything checks out before providing service or goods.
			*/
	
         	if (requestCode == RaveConstants.RAVE_REQUEST_CODE && result != null) {

			String message = result.getString("response");

			    if (message != null) {
				Log.d("rave response", message);
			    }

			    if (resultCode == RavePayActivity.RESULT_SUCCESS) {
				Toast.makeText(requireContext(), "SUCCESS " + message, Toast.LENGTH_SHORT).show();
			    } else if (resultCode == RavePayActivity.RESULT_ERROR) {
				Toast.makeText(requireContext(), "ERROR " + message, Toast.LENGTH_SHORT).show();
			    } else if (resultCode == RavePayActivity.RESULT_CANCELLED) {
				Toast.makeText(requireContext(), "CANCELLED " + message, Toast.LENGTH_SHORT).show();
			    }
		    
          	 }
    }
    
```
Rave's Android SDK
MIT License

Copyright (c) 2020

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
