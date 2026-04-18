.class public Lorg/drinkless/tdlib/TdApi$SetDefaultBackground;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetDefaultBackground"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Background;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x762e575f


# instance fields
.field public background:Lorg/drinkless/tdlib/TdApi$InputBackground;

.field public forDarkTheme:Z

.field public type:Lorg/drinkless/tdlib/TdApi$BackgroundType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 40306
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40307
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputBackground;Lorg/drinkless/tdlib/TdApi$BackgroundType;Z)V
    .locals 0
    .param p1, "inputBackground"    # Lorg/drinkless/tdlib/TdApi$InputBackground;
    .param p2, "backgroundType"    # Lorg/drinkless/tdlib/TdApi$BackgroundType;
    .param p3, "z8"    # Z

    .line 40295
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40296
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetDefaultBackground;->background:Lorg/drinkless/tdlib/TdApi$InputBackground;

    .line 40297
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SetDefaultBackground;->type:Lorg/drinkless/tdlib/TdApi$BackgroundType;

    .line 40298
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$SetDefaultBackground;->forDarkTheme:Z

    .line 40299
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 40303
    const v0, -0x762e575f

    return v0
.end method
