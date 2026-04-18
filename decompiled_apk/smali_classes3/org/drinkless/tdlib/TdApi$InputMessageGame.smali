.class public Lorg/drinkless/tdlib/TdApi$InputMessageGame;
.super Lorg/drinkless/tdlib/TdApi$InputMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputMessageGame"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4aae6ae2


# instance fields
.field public botUserId:J

.field public gameShortName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27344
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputMessageContent;-><init>()V

    .line 27345
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;

    .line 27334
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputMessageContent;-><init>()V

    .line 27335
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$InputMessageGame;->botUserId:J

    .line 27336
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$InputMessageGame;->gameShortName:Ljava/lang/String;

    .line 27337
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27341
    const v0, 0x4aae6ae2    # 5715313.0f

    return v0
.end method
