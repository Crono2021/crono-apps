.class public Lorg/drinkless/tdlib/TdApi$UpdateStory;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateStory"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1906572f


# instance fields
.field public story:Lorg/drinkless/tdlib/TdApi$Story;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22160
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 22161
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Story;)V
    .locals 0
    .param p1, "story"    # Lorg/drinkless/tdlib/TdApi$Story;

    .line 22151
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 22152
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateStory;->story:Lorg/drinkless/tdlib/TdApi$Story;

    .line 22153
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22157
    const v0, 0x1906572f

    return v0
.end method
