.class public Lorg/drinkless/tdlib/TdApi$UpdateNewChosenInlineResult;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateNewChosenInlineResult"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x34b3b0a3


# instance fields
.field public inlineMessageId:Ljava/lang/String;

.field public query:Ljava/lang/String;

.field public resultId:Ljava/lang/String;

.field public senderUserId:J

.field public userLocation:Lorg/drinkless/tdlib/TdApi$Location;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 49178
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 49179
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$Location;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "location"    # Lorg/drinkless/tdlib/TdApi$Location;
    .param p4, "str"    # Ljava/lang/String;
    .param p5, "str2"    # Ljava/lang/String;
    .param p6, "str3"    # Ljava/lang/String;

    .line 49165
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 49166
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewChosenInlineResult;->senderUserId:J

    .line 49167
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewChosenInlineResult;->userLocation:Lorg/drinkless/tdlib/TdApi$Location;

    .line 49168
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewChosenInlineResult;->query:Ljava/lang/String;

    .line 49169
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewChosenInlineResult;->resultId:Ljava/lang/String;

    .line 49170
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewChosenInlineResult;->inlineMessageId:Ljava/lang/String;

    .line 49171
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 49175
    const v0, -0x34b3b0a3    # -1.3389661E7f

    return v0
.end method
