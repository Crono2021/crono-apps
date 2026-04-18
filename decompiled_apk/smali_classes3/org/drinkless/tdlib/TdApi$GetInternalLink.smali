.class public Lorg/drinkless/tdlib/TdApi$GetInternalLink;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetInternalLink"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$HttpUrl;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3960f1b0


# instance fields
.field public isHttp:Z

.field public type:Lorg/drinkless/tdlib/TdApi$InternalLinkType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 26244
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26245
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InternalLinkType;Z)V
    .locals 0
    .param p1, "internalLinkType"    # Lorg/drinkless/tdlib/TdApi$InternalLinkType;
    .param p2, "z8"    # Z

    .line 26234
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26235
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetInternalLink;->type:Lorg/drinkless/tdlib/TdApi$InternalLinkType;

    .line 26236
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$GetInternalLink;->isHttp:Z

    .line 26237
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 26241
    const v0, 0x3960f1b0

    return v0
.end method
