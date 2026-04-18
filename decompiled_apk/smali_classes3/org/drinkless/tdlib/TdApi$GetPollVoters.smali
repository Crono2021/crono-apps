.class public Lorg/drinkless/tdlib/TdApi$GetPollVoters;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetPollVoters"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$MessageSenders;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3ba45654


# instance fields
.field public chatId:J

.field public limit:I

.field public messageId:J

.field public offset:I

.field public optionId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 47566
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 47567
    return-void
.end method

.method public constructor <init>(JJIII)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "i9"    # I
    .param p6, "i10"    # I
    .param p7, "i11"    # I

    .line 47553
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 47554
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetPollVoters;->chatId:J

    .line 47555
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$GetPollVoters;->messageId:J

    .line 47556
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$GetPollVoters;->optionId:I

    .line 47557
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$GetPollVoters;->offset:I

    .line 47558
    iput p7, p0, Lorg/drinkless/tdlib/TdApi$GetPollVoters;->limit:I

    .line 47559
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 47563
    const v0, -0x3ba45654

    return v0
.end method
