.class public Lorg/drinkless/tdlib/TdApi$DeviceTokenWebPush;
.super Lorg/drinkless/tdlib/TdApi$DeviceToken;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeviceTokenWebPush"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x65002109


# instance fields
.field public authBase64url:Ljava/lang/String;

.field public endpoint:Ljava/lang/String;

.field public p256dhBase64url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 36674
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$DeviceToken;-><init>()V

    .line 36675
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "str3"    # Ljava/lang/String;

    .line 36663
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$DeviceToken;-><init>()V

    .line 36664
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$DeviceTokenWebPush;->endpoint:Ljava/lang/String;

    .line 36665
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$DeviceTokenWebPush;->p256dhBase64url:Ljava/lang/String;

    .line 36666
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$DeviceTokenWebPush;->authBase64url:Ljava/lang/String;

    .line 36667
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 36671
    const v0, -0x65002109

    return v0
.end method
