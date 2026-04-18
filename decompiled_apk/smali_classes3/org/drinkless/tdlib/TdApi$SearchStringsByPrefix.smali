.class public Lorg/drinkless/tdlib/TdApi$SearchStringsByPrefix;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SearchStringsByPrefix"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$FoundPositions;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x78985e07


# instance fields
.field public limit:I

.field public query:Ljava/lang/String;

.field public returnNoneForEmptyQuery:Z

.field public strings:[Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45102
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 45103
    return-void
.end method

.method public constructor <init>([Ljava/lang/String;Ljava/lang/String;IZ)V
    .locals 0
    .param p1, "strArr"    # [Ljava/lang/String;
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "i9"    # I
    .param p4, "z8"    # Z

    .line 45090
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 45091
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SearchStringsByPrefix;->strings:[Ljava/lang/String;

    .line 45092
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SearchStringsByPrefix;->query:Ljava/lang/String;

    .line 45093
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$SearchStringsByPrefix;->limit:I

    .line 45094
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$SearchStringsByPrefix;->returnNoneForEmptyQuery:Z

    .line 45095
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45099
    const v0, -0x78985e07

    return v0
.end method
