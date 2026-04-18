.class public Lorg/drinkless/tdlib/TdApi$InputFileGenerated;
.super Lorg/drinkless/tdlib/TdApi$InputFile;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputFileGenerated"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4f79d800


# instance fields
.field public conversion:Ljava/lang/String;

.field public expectedSize:J

.field public originalPath:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37930
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputFile;-><init>()V

    .line 37931
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;J)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "j5"    # J

    .line 37919
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputFile;-><init>()V

    .line 37920
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputFileGenerated;->originalPath:Ljava/lang/String;

    .line 37921
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InputFileGenerated;->conversion:Ljava/lang/String;

    .line 37922
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$InputFileGenerated;->expectedSize:J

    .line 37923
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37927
    const v0, -0x4f79d800

    return v0
.end method
