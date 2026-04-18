.class public Lorg/drinkless/tdlib/TdApi$StoryContentPhoto;
.super Lorg/drinkless/tdlib/TdApi$StoryContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StoryContentPhoto"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2ba0ffb0


# instance fields
.field public photo:Lorg/drinkless/tdlib/TdApi$Photo;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20418
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StoryContent;-><init>()V

    .line 20419
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Photo;)V
    .locals 0
    .param p1, "photo"    # Lorg/drinkless/tdlib/TdApi$Photo;

    .line 20409
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StoryContent;-><init>()V

    .line 20410
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StoryContentPhoto;->photo:Lorg/drinkless/tdlib/TdApi$Photo;

    .line 20411
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20415
    const v0, -0x2ba0ffb0

    return v0
.end method
