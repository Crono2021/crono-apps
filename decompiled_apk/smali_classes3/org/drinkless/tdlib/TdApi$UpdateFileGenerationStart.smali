.class public Lorg/drinkless/tdlib/TdApi$UpdateFileGenerationStart;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateFileGenerationStart"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0xcec5eec


# instance fields
.field public conversion:Ljava/lang/String;

.field public destinationPath:Ljava/lang/String;

.field public generationId:J

.field public originalPath:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 46062
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 46063
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "str2"    # Ljava/lang/String;
    .param p5, "str3"    # Ljava/lang/String;

    .line 46050
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 46051
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateFileGenerationStart;->generationId:J

    .line 46052
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateFileGenerationStart;->originalPath:Ljava/lang/String;

    .line 46053
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$UpdateFileGenerationStart;->destinationPath:Ljava/lang/String;

    .line 46054
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$UpdateFileGenerationStart;->conversion:Ljava/lang/String;

    .line 46055
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 46059
    const v0, 0xcec5eec

    return v0
.end method
