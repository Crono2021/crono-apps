.class public Lorg/drinkless/tdlib/TdApi$BotMediaPreview;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BotMediaPreview"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x614a6318


# instance fields
.field public content:Lorg/drinkless/tdlib/TdApi$StoryContent;

.field public date:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23244
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 23245
    return-void
.end method

.method public constructor <init>(ILorg/drinkless/tdlib/TdApi$StoryContent;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "storyContent"    # Lorg/drinkless/tdlib/TdApi$StoryContent;

    .line 23234
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 23235
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$BotMediaPreview;->date:I

    .line 23236
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$BotMediaPreview;->content:Lorg/drinkless/tdlib/TdApi$StoryContent;

    .line 23237
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23241
    const v0, -0x614a6318

    return v0
.end method
