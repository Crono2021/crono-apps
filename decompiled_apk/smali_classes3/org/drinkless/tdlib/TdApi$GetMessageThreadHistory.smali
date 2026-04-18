.class public Lorg/drinkless/tdlib/TdApi$GetMessageThreadHistory;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetMessageThreadHistory"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Messages;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6bca2bd8


# instance fields
.field public chatId:J

.field public fromMessageId:J

.field public limit:I

.field public messageId:J

.field public offset:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 47540
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 47541
    return-void
.end method

.method public constructor <init>(JJJII)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "j10"    # J
    .param p7, "i9"    # I
    .param p8, "i10"    # I

    .line 47527
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 47528
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetMessageThreadHistory;->chatId:J

    .line 47529
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$GetMessageThreadHistory;->messageId:J

    .line 47530
    iput-wide p5, p0, Lorg/drinkless/tdlib/TdApi$GetMessageThreadHistory;->fromMessageId:J

    .line 47531
    iput p7, p0, Lorg/drinkless/tdlib/TdApi$GetMessageThreadHistory;->offset:I

    .line 47532
    iput p8, p0, Lorg/drinkless/tdlib/TdApi$GetMessageThreadHistory;->limit:I

    .line 47533
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 47537
    const v0, -0x6bca2bd8    # -9.180005E-27f

    return v0
.end method
