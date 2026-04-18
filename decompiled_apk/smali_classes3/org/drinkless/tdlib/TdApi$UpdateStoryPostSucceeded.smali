.class public Lorg/drinkless/tdlib/TdApi$UpdateStoryPostSucceeded;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateStoryPostSucceeded"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6611a4be


# instance fields
.field public oldStoryId:I

.field public story:Lorg/drinkless/tdlib/TdApi$Story;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34968
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34969
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Story;I)V
    .locals 0
    .param p1, "story"    # Lorg/drinkless/tdlib/TdApi$Story;
    .param p2, "i9"    # I

    .line 34958
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34959
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateStoryPostSucceeded;->story:Lorg/drinkless/tdlib/TdApi$Story;

    .line 34960
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateStoryPostSucceeded;->oldStoryId:I

    .line 34961
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34965
    const v0, -0x6611a4be

    return v0
.end method
