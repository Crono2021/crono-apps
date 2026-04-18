.class public Lorg/drinkless/tdlib/TdApi$PersonalDocument;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PersonalDocument"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3c4c51e5


# instance fields
.field public files:[Lorg/drinkless/tdlib/TdApi$DatedFile;

.field public translation:[Lorg/drinkless/tdlib/TdApi$DatedFile;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29304
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 29305
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$DatedFile;[Lorg/drinkless/tdlib/TdApi$DatedFile;)V
    .locals 0
    .param p1, "datedFileArr"    # [Lorg/drinkless/tdlib/TdApi$DatedFile;
    .param p2, "datedFileArr2"    # [Lorg/drinkless/tdlib/TdApi$DatedFile;

    .line 29294
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 29295
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PersonalDocument;->files:[Lorg/drinkless/tdlib/TdApi$DatedFile;

    .line 29296
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$PersonalDocument;->translation:[Lorg/drinkless/tdlib/TdApi$DatedFile;

    .line 29297
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29301
    const v0, -0x3c4c51e5

    return v0
.end method
