.class public Lorg/drinkless/tdlib/TdApi$RemoveRecentSticker;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RemoveRecentSticker"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4a4d440d


# instance fields
.field public isAttached:Z

.field public sticker:Lorg/drinkless/tdlib/TdApi$InputFile;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29988
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 29989
    return-void
.end method

.method public constructor <init>(ZLorg/drinkless/tdlib/TdApi$InputFile;)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "inputFile"    # Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 29978
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 29979
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$RemoveRecentSticker;->isAttached:Z

    .line 29980
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$RemoveRecentSticker;->sticker:Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 29981
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29985
    const v0, 0x4a4d440d    # 3363075.2f

    return v0
.end method
