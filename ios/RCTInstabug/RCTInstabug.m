//
//  RCTInstabug.m
//  RCTInstabug
//
//  Created by Emma on 16/10/2.
//  Copyright © 2016年 react-native-instabug. All rights reserved.
//

#import "RCTInstabug.h"

@implementation RCTInstabug

- (dispatch_queue_t)(methodQueue)
{
    return dispatch_get_main_queue();
}
RTC_EXPORT_MODULE()

@end
