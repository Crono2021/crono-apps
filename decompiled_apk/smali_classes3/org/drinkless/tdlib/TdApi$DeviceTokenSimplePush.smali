.class public Lorg/drinkless/tdlib/TdApi$DeviceTokenSimplePush;
.super Lorg/drinkless/tdlib/TdApi$DeviceToken;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeviceTokenSimplePush"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2f49a60


# instance fields
.field public endpoint:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11472
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$DeviceToken;-><init>()V

    .line 11473
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 11463
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$DeviceToken;-><init>()V

    .line 11464
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$DeviceTokenSimplePush;->endpoint:Ljava/lang/String;

    .line 11465
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 11469
    const v0, 0x2f49a60

    return v0
.end method
