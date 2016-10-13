#import "RCTBridgeModule.h"

//---------This file only learning Objective-C---------//

//http://www.jianshu.com/p/e8d2d8e1e21f
/*
 RCT_EXPORT_METHOD支持需要JSON所支持的数据类型，JavaScript中的参数与Object-C的参数的对应关系。
 
 string -> NSString
 number -> (NSInteger,float,double,CGFloat,NSNumber)
 boolean -> (BOOL,NSNumber)
 array -> NSArray
 object -> NSDictionary
 function -> RCTResponseSenderBlock 
 */

//RCT是ReaCT的缩写，React Native中Object-C相关的命名均以RCT开头。
@interface RCTDeviceExtension : NSObject<RCTBridgeModule>


@end
