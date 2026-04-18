.class public Lorg/drinkless/tdlib/TdApi$PushMessageContentGameScore;
.super Lorg/drinkless/tdlib/TdApi$PushMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PushMessageContentGameScore"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x35b8cd88


# instance fields
.field public isPinned:Z

.field public score:I

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 39228
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 39229
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;IZ)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "i9"    # I
    .param p3, "z8"    # Z

    .line 39217
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 39218
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentGameScore;->title:Ljava/lang/String;

    .line 39219
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentGameScore;->score:I

    .line 39220
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentGameScore;->isPinned:Z

    .line 39221
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 39225
    const v0, 0x35b8cd88

    return v0
.end method
