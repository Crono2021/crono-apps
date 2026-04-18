.class public Lorg/drinkless/tdlib/TdApi$SearchFileDownloads;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SearchFileDownloads"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$FoundFileDownloads;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2a1e0856


# instance fields
.field public limit:I

.field public offset:Ljava/lang/String;

.field public onlyActive:Z

.field public onlyCompleted:Z

.field public query:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 48528
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 48529
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;ZZLjava/lang/String;I)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "z8"    # Z
    .param p3, "z9"    # Z
    .param p4, "str2"    # Ljava/lang/String;
    .param p5, "i9"    # I

    .line 48515
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 48516
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SearchFileDownloads;->query:Ljava/lang/String;

    .line 48517
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$SearchFileDownloads;->onlyActive:Z

    .line 48518
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$SearchFileDownloads;->onlyCompleted:Z

    .line 48519
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$SearchFileDownloads;->offset:Ljava/lang/String;

    .line 48520
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$SearchFileDownloads;->limit:I

    .line 48521
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 48525
    const v0, 0x2a1e0856

    return v0
.end method
