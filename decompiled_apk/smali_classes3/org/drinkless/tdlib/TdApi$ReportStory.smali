.class public Lorg/drinkless/tdlib/TdApi$ReportStory;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReportStory"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$ReportStoryResult;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6cacaf34


# instance fields
.field public optionId:[B

.field public storyId:I

.field public storyPosterChatId:J

.field public text:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 44934
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 44935
    return-void
.end method

.method public constructor <init>(JI[BLjava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "bArr"    # [B
    .param p5, "str"    # Ljava/lang/String;

    .line 44922
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 44923
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ReportStory;->storyPosterChatId:J

    .line 44924
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$ReportStory;->storyId:I

    .line 44925
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$ReportStory;->optionId:[B

    .line 44926
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$ReportStory;->text:Ljava/lang/String;

    .line 44927
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 44931
    const v0, 0x6cacaf34

    return v0
.end method
