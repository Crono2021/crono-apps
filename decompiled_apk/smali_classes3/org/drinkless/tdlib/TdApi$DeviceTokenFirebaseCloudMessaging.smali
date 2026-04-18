.class public Lorg/drinkless/tdlib/TdApi$DeviceTokenFirebaseCloudMessaging;
.super Lorg/drinkless/tdlib/TdApi$DeviceToken;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeviceTokenFirebaseCloudMessaging"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2f8eb5f9


# instance fields
.field public encrypt:Z

.field public token:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25244
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$DeviceToken;-><init>()V

    .line 25245
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Z)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "z8"    # Z

    .line 25234
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$DeviceToken;-><init>()V

    .line 25235
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$DeviceTokenFirebaseCloudMessaging;->token:Ljava/lang/String;

    .line 25236
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$DeviceTokenFirebaseCloudMessaging;->encrypt:Z

    .line 25237
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25241
    const v0, -0x2f8eb5f9

    return v0
.end method
