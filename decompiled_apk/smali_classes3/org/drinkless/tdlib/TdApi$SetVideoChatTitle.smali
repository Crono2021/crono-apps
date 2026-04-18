.class public Lorg/drinkless/tdlib/TdApi$SetVideoChatTitle;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetVideoChatTitle"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x722bf372


# instance fields
.field public groupCallId:I

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32248
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 32249
    return-void
.end method

.method public constructor <init>(ILjava/lang/String;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "str"    # Ljava/lang/String;

    .line 32238
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 32239
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$SetVideoChatTitle;->groupCallId:I

    .line 32240
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SetVideoChatTitle;->title:Ljava/lang/String;

    .line 32241
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32245
    const v0, 0x722bf372

    return v0
.end method
