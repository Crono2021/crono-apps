.class public Lorg/drinkless/tdlib/TdApi$InternalLinkTypeStory;
.super Lorg/drinkless/tdlib/TdApi$InternalLinkType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InternalLinkTypeStory"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6e63ee75


# instance fields
.field public storyId:I

.field public storyPosterUsername:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27784
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 27785
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "i9"    # I

    .line 27774
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 27775
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeStory;->storyPosterUsername:Ljava/lang/String;

    .line 27776
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeStory;->storyId:I

    .line 27777
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27781
    const v0, 0x6e63ee75

    return v0
.end method
