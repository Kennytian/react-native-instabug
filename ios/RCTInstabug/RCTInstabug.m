#import "RCTInstabug.h"
#import "RCTConvert.h"

@implementation RCTInstabug

RCT_EXPORT_MODULE();

RCT_EXPORT_METHOD(report:(NSString *)flag)
{
    RCTLogInfo(@"You input result is %@", flag);
}

RCT_EXPORT_METHOD(addTags:(NSString *)tags)
{
    RCTLogInfo(@"You input result is %@", tags);
}

RCT_EXPORT_METHOD(changeLocale:(NSString *)languageTag)
{
    RCTLogInfo(@"You input result is %@", languageTag);
}

RCT_EXPORT_METHOD(setFileAttachment:(NSString *)fileUri fileNameWithExtension:(NSString *)fileNameWithExtension)
{
    RCTLogInfo(@"You input result is %@ and %@", fileUri, fileNameWithExtension);
}

RCT_EXPORT_METHOD(setUserEmail:(NSString *)userEmail)
{
    RCTLogInfo(@"You input result is %@", userEmail);
}

RCT_EXPORT_METHOD(setUsername:(NSString *)username)
{
    RCTLogInfo(@"You input result is %@", username);
}

RCT_EXPORT_METHOD(setUserData:(NSString *)userData)
{
    RCTLogInfo(@"You input result is %@", userData);
}

RCT_EXPORT_METHOD(showIntroMessage)
{
    RCTLogInfo(@"showIntroMessage");
}

@end