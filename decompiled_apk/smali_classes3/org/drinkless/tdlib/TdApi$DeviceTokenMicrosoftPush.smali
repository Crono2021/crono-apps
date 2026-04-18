.class public Lorg/drinkless/tdlib/TdApi$DeviceTokenMicrosoftPush;
.super Lorg/drinkless/tdlib/TdApi$DeviceToken;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeviceTokenMicrosoftPush"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x48f8e04c


# instance fields
.field public channelUri:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11436
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$DeviceToken;-><init>()V

    .line 11437
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 11427
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$DeviceToken;-><init>()V

    .line 11428
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$DeviceTokenMicrosoftPush;->channelUri:Ljava/lang/String;

    .line 11429
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 11433
    const v0, 0x48f8e04c

    return v0
.end method
