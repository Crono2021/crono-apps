.class public Lorg/drinkless/tdlib/TdApi$GetExternalLink;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetExternalLink"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$HttpUrl;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5e92f0eb


# instance fields
.field public allowWriteAccess:Z

.field public link:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 26064
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26065
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Z)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "z8"    # Z

    .line 26054
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26055
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetExternalLink;->link:Ljava/lang/String;

    .line 26056
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$GetExternalLink;->allowWriteAccess:Z

    .line 26057
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 26061
    const v0, 0x5e92f0eb

    return v0
.end method
