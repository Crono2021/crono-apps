.class public Lorg/drinkless/tdlib/TdApi$SetInlineGameScore;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetInlineGameScore"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x388ea275


# instance fields
.field public editMessage:Z

.field public force:Z

.field public inlineMessageId:Ljava/lang/String;

.field public score:I

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 48684
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 48685
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;ZJIZ)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "z8"    # Z
    .param p3, "j5"    # J
    .param p5, "i9"    # I
    .param p6, "z9"    # Z

    .line 48671
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 48672
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetInlineGameScore;->inlineMessageId:Ljava/lang/String;

    .line 48673
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$SetInlineGameScore;->editMessage:Z

    .line 48674
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$SetInlineGameScore;->userId:J

    .line 48675
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$SetInlineGameScore;->score:I

    .line 48676
    iput-boolean p6, p0, Lorg/drinkless/tdlib/TdApi$SetInlineGameScore;->force:Z

    .line 48677
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 48681
    const v0, -0x388ea275

    return v0
.end method
