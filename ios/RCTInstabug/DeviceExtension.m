#import "RCTConvert.h"
#import "RCTEventDispatcher.h"
#import "DeviceExtension.h"
#import "RCTUtils.h"
#import <UIKit/UIKit.h>

//---------This file only learning Objective-C---------//

@implementation RCTDeviceExtension

@synthesize bridge = _bridge;

RCT_EXPORT_MODULE();

RCT_EXPORT_METHOD(showMsg:(NSString *)msg){
    UIAlertView *alertView= [[UIAlertView alloc]
                             initWithTitle:@"Alert Title" message:msg delegate:nil
                             cancelButtonTitle:@"Close"
                             otherButtonTitles:nil,
                             nil];
    [alertView show];
}

RCT_EXPORT_METHOD(showTime:(NSDictionary *)dict){
    NSDate *date = [RCTConvert NSDate:dict[@"time"]];
    RCTLogInfo(@"show time %@", date);
}

RCT_EXPORT_METHOD(greet:(NSString *)name){
    NSLog(@"Hi %@!", name);
    [_bridge.eventDispatcher sendAppEventWithName:@"greeted" body:@{ @"name": @"nmae"}];
}

RCT_EXPORT_METHOD(getDynamicDimensions:(RCTResponseSenderBlock)callback){
    callback(@[[NSNull null], DynamicDimensions()]);
}
static NSDictionary *DynamicDimensions(){
    CGFloat width = MIN(RCTScreenSize().width, RCTScreenSize().height);
    CGFloat height = MAX(RCTScreenSize().width, RCTScreenSize().height);
    CGFloat scale = RCTScreenScale();
    
    if (UIDeviceOrientationIsLandscape([UIDevice currentDevice].orientation)) {
        width = MAX(RCTScreenSize().width, RCTScreenSize().height);
        height = MIN(RCTScreenSize().width, RCTScreenSize().height);
    }
    
    return @{@"width":@(width),@"height":@(height),@"scale":@(scale)};
}


@end
