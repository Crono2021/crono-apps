.class public Lorg/drinkless/tdlib/TdApi$Audios;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Audios"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x28927d56


# instance fields
.field public audios:[Lorg/drinkless/tdlib/TdApi$Audio;

.field public totalCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22944
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 22945
    return-void
.end method

.method public constructor <init>(I[Lorg/drinkless/tdlib/TdApi$Audio;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "audioArr"    # [Lorg/drinkless/tdlib/TdApi$Audio;

    .line 22934
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 22935
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$Audios;->totalCount:I

    .line 22936
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$Audios;->audios:[Lorg/drinkless/tdlib/TdApi$Audio;

    .line 22937
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22941
    const v0, -0x28927d56

    return v0
.end method
