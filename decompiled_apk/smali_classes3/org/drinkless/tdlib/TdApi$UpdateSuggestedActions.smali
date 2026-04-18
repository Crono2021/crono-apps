.class public Lorg/drinkless/tdlib/TdApi$UpdateSuggestedActions;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateSuggestedActions"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x56fd79ba


# instance fields
.field public addedActions:[Lorg/drinkless/tdlib/TdApi$SuggestedAction;

.field public removedActions:[Lorg/drinkless/tdlib/TdApi$SuggestedAction;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35008
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 35009
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$SuggestedAction;[Lorg/drinkless/tdlib/TdApi$SuggestedAction;)V
    .locals 0
    .param p1, "suggestedActionArr"    # [Lorg/drinkless/tdlib/TdApi$SuggestedAction;
    .param p2, "suggestedActionArr2"    # [Lorg/drinkless/tdlib/TdApi$SuggestedAction;

    .line 34998
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34999
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateSuggestedActions;->addedActions:[Lorg/drinkless/tdlib/TdApi$SuggestedAction;

    .line 35000
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateSuggestedActions;->removedActions:[Lorg/drinkless/tdlib/TdApi$SuggestedAction;

    .line 35001
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 35005
    const v0, 0x56fd79ba

    return v0
.end method
