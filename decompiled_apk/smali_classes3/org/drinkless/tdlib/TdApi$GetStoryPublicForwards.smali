.class public Lorg/drinkless/tdlib/TdApi$GetStoryPublicForwards;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetStoryPublicForwards"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$PublicForwards;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6be82f32


# instance fields
.field public limit:I

.field public offset:Ljava/lang/String;

.field public storyId:I

.field public storyPosterChatId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 43614
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43615
    return-void
.end method

.method public constructor <init>(JILjava/lang/String;I)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "str"    # Ljava/lang/String;
    .param p5, "i10"    # I

    .line 43602
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43603
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetStoryPublicForwards;->storyPosterChatId:J

    .line 43604
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$GetStoryPublicForwards;->storyId:I

    .line 43605
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$GetStoryPublicForwards;->offset:Ljava/lang/String;

    .line 43606
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$GetStoryPublicForwards;->limit:I

    .line 43607
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 43611
    const v0, 0x6be82f32

    return v0
.end method
