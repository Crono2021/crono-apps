.class public Lorg/drinkless/tdlib/TdApi$GetInlineGameHighScores;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetInlineGameHighScores"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$GameHighScores;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1fc69456


# instance fields
.field public inlineMessageId:Ljava/lang/String;

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 26224
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26225
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;J)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "j5"    # J

    .line 26214
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26215
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetInlineGameHighScores;->inlineMessageId:Ljava/lang/String;

    .line 26216
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$GetInlineGameHighScores;->userId:J

    .line 26217
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 26221
    const v0, -0x1fc69456

    return v0
.end method
