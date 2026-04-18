.class public Lorg/drinkless/tdlib/TdApi$GetMessageAvailableReactions;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetMessageAvailableReactions"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$AvailableReactions;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x76db86b2


# instance fields
.field public chatId:J

.field public messageId:J

.field public rowSize:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37400
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37401
    return-void
.end method

.method public constructor <init>(JJI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "i9"    # I

    .line 37389
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37390
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetMessageAvailableReactions;->chatId:J

    .line 37391
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$GetMessageAvailableReactions;->messageId:J

    .line 37392
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$GetMessageAvailableReactions;->rowSize:I

    .line 37393
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37397
    const v0, 0x76db86b2

    return v0
.end method
