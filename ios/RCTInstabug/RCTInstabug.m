#import "RCTInstabug.h"

@implementation RCTInstabug

- (dispatch_queue_t)(methodQueue)
{
    return dispatch_get_main_queue();
}
RTC_EXPORT_MODULE()

@end
